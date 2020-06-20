package com.dev.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TracingAspect {
	boolean enterCalled = false;
	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
	
	public boolean isEnterCalled(){
		return enterCalled;
	}
	@Before("execution(* * (..))")
	public void enter(JoinPoint joinPoint){
		enterCalled = true;
		logger.trace("entering" + joinPoint.getStaticPart().getSignature().toString());
	}
}
