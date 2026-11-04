package com.educator.aspect;

import com.educator.core.exception.CodeSageRuntimeException;
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

@Aspect
@Component
@RequiredArgsConstructor
public class CourseAccessAspect {

    private final ServiceAccess serviceAccess;

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
        serviceAccess.checkAccess(id, courseAccess);
    }

}
