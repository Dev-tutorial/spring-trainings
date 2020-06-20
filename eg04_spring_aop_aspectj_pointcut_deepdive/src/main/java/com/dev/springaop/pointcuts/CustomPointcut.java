package com.dev.springaop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CustomPointcut {
	@Pointcut("bean(*Service)")
	public void beanNamePointcut() {
	}
}
