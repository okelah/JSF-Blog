package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by vlad on 24.08.16.
 */
@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.github.vlsidlyarevich.spring.boot.jsf.blog" +
            ".app.service.PostService.*(..)))")
    public void postServiceLog(JoinPoint joinPoint) {
        logger.info("Post service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.github.vlsidlyarevich.spring.boot.jsf.blog" +
            ".app.service.CommentService.*(..))")
    public void commentServiceLog(JoinPoint joinPoint) {
        logger.info("Comment service : " + joinPoint.getSignature().getName());
    }
}
