package com.dev.springaop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWithafterReturningAdvice {
	private boolean afterReturningAdvice = false;
	private Logger logger = LoggerFactory.getLogger(AspectWithafterReturningAdvice.class);
	
	public void reset(){
		afterReturningAdvice = false;
	}
	public boolean isAfterReturningAdvice(){
		System.out.println("After returning advice called?: "+ afterReturningAdvice);
		return afterReturningAdvice;
	}
	@AfterReturning(pointcut = "execution(* *(..))", returning = "string")
	public void logResult(String string){
		afterReturningAdvice = true;
		logger.trace("Result::: "+ string);
	}
}
