package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AspectWithAfterAdvice;
import com.dev.springaop.configuration.AdviceDeepDiveSystemConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AdviceDeepDiveSystemConfiguration.class)
public class AspectWithAfterAdviceTest {
	@Autowired
	private DemoService service;
	@Autowired
	private AspectWithAfterAdvice aspectAfterAdvice;
	@Before
	public void reset(){
		aspectAfterAdvice.reset();
	}
	@Test
	public void afterIsCalledIfMethodReturnSuccess(){
		assertFalse(aspectAfterAdvice.isAfterAdviceCalled());
		service.example();
		service.differentExample();
		assertTrue(aspectAfterAdvice.isAfterAdviceCalled());
		assertTrue(aspectAfterAdvice.isAfterAdviceCalled());
	}
	@Test(expected = RuntimeException.class)
	public void afterIsCalledIfMethodThrowsExcep(){
		assertFalse(aspectAfterAdvice.isAfterAdviceCalled());
		try {
			service.throwsRunTimeExcep();
		} finally {
			assertTrue(aspectAfterAdvice.isAfterAdviceCalled());
		}
		
	}
}
