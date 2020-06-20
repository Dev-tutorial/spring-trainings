package com.dev.springaop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogAspect extends CallTracker{
	Logger logger = LoggerFactory.getLogger(ExceptionLogAspect.class);
	
	@AfterThrowing(pointcut="com.dev.springaop.architecture.SystemArchitecture.Service() || com.dev.springaop.architecture.SystemArchitecture.Repository()", throwing= "ex")
	public void logException(Exception ex) {
		trackCall();
		logger.error("Exception:::", ex);
	}
}
