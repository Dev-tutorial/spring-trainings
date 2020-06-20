package com.dev.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectWithAroundAdvice {
	Logger logger = LoggerFactory.getLogger(AspectWithAroundAdvice.class);
	private boolean aroundAdvicecalled;

	public void reset() {
		aroundAdvicecalled = false;
	}
	public boolean isAroundAdviceCalled() {
		return aroundAdvicecalled;
	}
	@Around("execution(* *(..))")
	public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable {
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		logger.trace("Entering " + methodInformation);
		aroundAdvicecalled = true;
		try {
			return proceedingJP.proceed();
		} catch (Throwable ex) {
			logger.error("Exception in " + methodInformation, ex);
			throw ex;
		} finally {
			logger.trace("Exiting " + methodInformation);
		}
	}
}
