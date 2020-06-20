package com.dev.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWithAfterThrowingAdvice {
	private boolean afterThrowingAdvice = false;
	private Logger logger = LoggerFactory.getLogger(AspectWithAfterThrowingAdvice.class);
	
	public void reset(){
		afterThrowingAdvice = false;
	}
	public boolean isAfterThrowingAdviceCalled(){
		System.out.println("After throwing advice called?: " +afterThrowingAdvice);
		return afterThrowingAdvice;
	}
	@AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex") // calls throwsRunTimeExcep()
	public void logException(RuntimeException ex){
		afterThrowingAdvice = true;
		logger.error("Exception from advice: " + ex);
	}
}
