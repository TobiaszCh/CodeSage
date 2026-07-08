package com.educator.aspect;

import com.educator.auth.AuthService;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.subject.SubjectRepository;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
@RequiredArgsConstructor
public class ModificationAccessAspect {

    public final AuthService authService;

    public final CourseRepository courseRepository;

    private final SubjectRepository subjectRepository;

    @Before("@annotation(modificationAccess)")
    public void before(JoinPoint joinPoint, ModificationAccess modificationAccess) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        EvaluationContext context = new StandardEvaluationContext();

        if(parameterNames.length != args.length) {
            throw new CodeSageRuntimeException("parameterNames length is other then args length");
        }

        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        ExpressionParser expressionParser = new SpelExpressionParser();
        Long id = expressionParser.parseExpression(modificationAccess.idExpression()).getValue(context, Long.class);

        switch (modificationAccess.objectType()) {
            case COURSE:
                checkAccessToCourseMethod(id);
                break;
            case SUBJECT:
                checkAccessToSubjectMethod(id);
                break;
        }
    }

    private void checkAccessToCourseMethod(Long courseId) {
        checkAccess(courseId);
    }

    private void checkAccessToSubjectMethod(Long subjectId) {
        Long courseId = Optional.ofNullable(subjectId)
                .flatMap(subjectRepository::findCourseIdBySubjectId)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + subjectId + " doesn't exist"));
        checkAccess(courseId);
    }

    private void checkAccess(Long Id) {
        User loggedUser = authService.getLoggedUser();
        Course course = Optional.ofNullable(Id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + Id + " doesn't exist"));
        if (!loggedUser.getId().equals(course.getOwner().getId())) {
            throw new CodeSageRuntimeException("Access denied");
        }
    }

}
