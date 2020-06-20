package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.dev.springaop.aspect.TracingAspect;
import com.dev.springaop.demo.DemoClass;

public class ManualProxyCreateAndAddAdvice {
	
	@Test
	public void manualExampleCall(){
		TracingAspect tracingAspect = new TracingAspect();
		DemoClass originalObj = new DemoClass();
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(originalObj);
		proxyFactory.addAspect(tracingAspect);
		DemoClass proxy = proxyFactory.getProxy();
		assertFalse(tracingAspect.isCalled());
		proxy.example();
		assertTrue(tracingAspect.isCalled());
	}
	
}
