package com.dev.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TracingAspect {
	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
	@Before("execution(void example())")
	public void trace(JoinPoint jp){
		System.out.println("Aspect is called");
		logger.trace("Entering "+ jp.getStaticPart().getSignature().toString());
	}
}
