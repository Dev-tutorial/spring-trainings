package com.dev.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.springaop.demo.DemoClass;

@Aspect
@Component
public class TracingAspect extends CallTracker{

	Logger logger = LoggerFactory.getLogger(TracingAspect.class);
	@Autowired
	private DemoClass demoClass;
	@Before("execution(void example())")
	public void trace(JoinPoint joinPoint){
		logger.trace("Entering "+ joinPoint.getStaticPart().getSignature().toString());
		trackCall();
	}
}
