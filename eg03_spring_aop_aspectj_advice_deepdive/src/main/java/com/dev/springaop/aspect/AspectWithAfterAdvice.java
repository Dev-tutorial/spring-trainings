package com.dev.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWithAfterAdvice {
	
	Logger logger = LoggerFactory.getLogger(AspectWithAfterAdvice.class);
	private boolean afterAdviceCalled = false;
	
	public void reset(){
		afterAdviceCalled = false;
	}
	public boolean isAfterAdviceCalled(){
		System.out.println("after advice called?: " +afterAdviceCalled);
		return afterAdviceCalled;
	}
	
	@After("execution(* *(..))")
	public void exiting(JoinPoint joinPoint){
		afterAdviceCalled = true;
		logger.trace("exiting: " + joinPoint.getSignature());
		for(Object arg: joinPoint.getArgs()){
			logger.trace("After advice Args: "+ arg);
		}
	}
}
