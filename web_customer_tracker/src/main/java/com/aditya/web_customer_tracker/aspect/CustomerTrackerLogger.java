package com.aditya.web_customer_tracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerTrackerLogger {

	Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.aditya.web_customer_tracker.controller.*.*(..))")
	public void forControllerPointcut() {
	}

	@Pointcut("execution(* com.aditya.web_customer_tracker.service.*.*(..))")
	public void forServicePointcut() {
	}

	@Pointcut("execution(* com.aditya.web_customer_tracker.dao.*.*(..))")
	public void forDaoPointcut() {
	}

	@Pointcut("forControllerPointcut() || forServicePointcut() || forDaoPointcut()")
	public void forControllerServiceDAOPointcut() {
	}

	@Before("forControllerServiceDAOPointcut()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		myLogger.info("==>>@Before in method:" + methodName);
		Object[] args = joinPoint.getArgs();
		for (Object tempArg : args) {
			myLogger.info("==>>@Before arg:-" + tempArg);
		}
	}

	@AfterReturning(pointcut = "forControllerServiceDAOPointcut()", returning = "obj")
	public void after(JoinPoint joinPoint, Object obj) {
		String methodName = joinPoint.getSignature().toShortString();
		myLogger.info("==>>@AfterReturning in method:" + methodName);
		myLogger.info("==>>@AfterReturning return:-" + obj);
	}

}
