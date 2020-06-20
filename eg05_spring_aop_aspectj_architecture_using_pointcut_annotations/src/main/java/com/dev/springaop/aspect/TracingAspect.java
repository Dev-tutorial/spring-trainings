package com.dev.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect extends CallTracker{
	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
	
	@Around("com.dev.springaop.architecture.SystemArchitecture.Service() || com.dev.springaop.architecture.SystemArchitecture.Repository()")
	public void trace(ProceedingJoinPoint proceedingJP) throws Throwable{
		String methodInfo = proceedingJP.getStaticPart().getSignature().toString();
		logger.trace("Entering "+ methodInfo);
		trackCall();
		try {
			proceedingJP.proceed();
		} catch (Throwable e) {
			logger.error("Exception in "+ methodInfo, e);
			throw e;
		} finally {
			logger.trace("Exiting "+ methodInfo);
		}
	}
}
