package com.dev.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeanNameAspect {
	Logger logger = LoggerFactory.getLogger(BeanNameAspect.class);
	private boolean called = false;
	
	public void resetCalled(){
		called = false;
	}
	public boolean getCalled(){
		return called;
	}
	@Around("com.dev.springaop.pointcuts.CustomPointcut.beanNamePointcut()")
	public void trace(ProceedingJoinPoint proceedingJP) throws Throwable{
		String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
		logger.trace("Entering "+ methodInformation);
		called = true;
		try {
			proceedingJP.proceed();
		} catch (Throwable e) {
			logger.error("Exception in "+methodInformation, e);
			throw e;
		}finally {
			logger.trace("Exiting "+methodInformation);
		}
	}
}
