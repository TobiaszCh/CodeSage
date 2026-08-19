package com.educator.aspect;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.course.Visibility;
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
public class CourseAccessAspect {

    public final AuthService authService;
    public final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final AnswerSessionService answerSessionService;

    @Before("@annotation(courseAccess)")
    public void before(JoinPoint joinPoint, CourseAccess courseAccess) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        EvaluationContext context = new StandardEvaluationContext();

        if (parameterNames.length != args.length) {
            throw new CodeSageRuntimeException("parameterNames length is other than args length");
        }

        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        ExpressionParser expressionParser = new SpelExpressionParser();
        Long id = expressionParser.parseExpression(courseAccess.idExpression()).getValue(context, Long.class);

        switch (courseAccess.idEntityType()) {
            case COURSE:
                checkAccessByCourseId(id, courseAccess.accessPolicy());
                break;
            case SUBJECT:
                checkAccessBySubjectId(id, courseAccess.accessPolicy());
                break;
            case ANSWER_SESSION:
                checkAccessByAnswerSessionId(id, courseAccess.accessPolicy());
                break;
        }
    }

    private void checkAccessByCourseId(Long courseId, AccessPolicy accessPolicy) {
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessByAnswerSessionId(Long answerSessionId, AccessPolicy accessPolicy) {
        Long courseId = Optional.ofNullable(answerSessionId)
                .map(answerSessionService::getCourseId)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + answerSessionId + " doesn't exist"));
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessBySubjectId(Long subjectId, AccessPolicy accessPolicy) {
        Long courseId = Optional.ofNullable(subjectId)
                .flatMap(subjectRepository::findCourseIdBySubjectId)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + subjectId + " doesn't exist"));
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessToCourse(Long Id, AccessPolicy accessPolicy) {
        User loggedUser = authService.getLoggedUser();
        Course course = Optional.ofNullable(Id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + Id + " doesn't exist"));
        boolean isOwner = loggedUser.getId().equals(course.getOwner().getId());
        boolean isPublic = course.getVisibility() == Visibility.PUBLIC;
        switch (accessPolicy) {
            case MANAGE:
                if (!isOwner) {
                    throw new CodeSageRuntimeException("Access denied");
                }
                break;
            case LEARN:
                if (!isOwner && !isPublic) {
                    throw new CodeSageRuntimeException("Access denied");
                }
                break;
        }
    }

}
