package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AspectWithBeforeAdvice;
import com.dev.springaop.configuration.AdviceDeepDiveSystemConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AdviceDeepDiveSystemConfiguration.class)
public class AspectWithBeforeAdviceTest {
	@Autowired
	private DemoService service;
	@Autowired
	private AspectWithBeforeAdvice aspectBeforeAdvice;
	
	@Before
	public void reset(){
		aspectBeforeAdvice.reset();
	}
	@Test
	public void beforeIscalledIfCorrectMethodCalled(){
		assertFalse(aspectBeforeAdvice.isBeforeCalled());
		service.example();
		assertTrue(aspectBeforeAdvice.isBeforeCalled());
	}
	@Test
	public void beforeIsNOTCalledIfDifferentMethodCalled(){
		assertFalse(aspectBeforeAdvice.isBeforeCalled());
		service.differentExample();
		assertFalse(aspectBeforeAdvice.isBeforeCalled());
	}
}
