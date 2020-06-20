package com.dev.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWithBeforeAdvice {

	private Logger logger = LoggerFactory.getLogger(AspectWithBeforeAdvice.class);
	private boolean beforeCalled = false;
	
	public void reset(){
		beforeCalled = false;
	}
	public boolean isBeforeCalled(){
		System.out.println("before advice Called?: "+beforeCalled);
		return beforeCalled;
	}
	@Before("execution(void example())")
	public void entering(JoinPoint joinPoint){
		beforeCalled = true;
		logger.trace("entering " + joinPoint.getStaticPart().getSignature().toString());
	}
}
