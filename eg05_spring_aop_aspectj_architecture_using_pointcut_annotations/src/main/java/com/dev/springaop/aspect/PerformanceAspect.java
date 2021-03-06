package com.dev.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceAspect extends CallTracker{
	Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

	@Around("com.dev.springaop.architecture.SystemArchitecture.Repository()")
	public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		StopWatch stopWatch = new StopWatch(methodInformation);
		stopWatch.start();
		trackCall();
		try {
			proceedingJP.proceed();
		} finally {
			stopWatch.stop();
			logger.trace(stopWatch.shortSummary());
		}
	}
}
