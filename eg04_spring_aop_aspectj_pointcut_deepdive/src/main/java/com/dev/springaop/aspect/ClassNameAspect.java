package com.dev.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClassNameAspect {

	Logger logger = LoggerFactory.getLogger(ClassNameAspect.class);
	private boolean called= false;

	public void resetCalled() {
		called=false;
	}
	
	public boolean getCalled() {
		return called;
	}
	@Around("execution(* *..*Service.*(..))")
	public void trace(ProceedingJoinPoint proceedingJP ) throws Throwable {
		String methodInformation = 
				proceedingJP.getSignature().toString();
		logger.trace("Entering "+methodInformation);
		called = true;
		try {
			proceedingJP.proceed();
		} catch (Throwable ex) {
			logger.error("Exception in "+methodInformation, ex);
			throw ex;
		} finally {
			logger.trace("Exiting "+methodInformation);
		}
	}
}
