package com.dev.springaop.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AspectWithAroundAdvice;
import com.dev.springaop.configuration.AdviceDeepDiveSystemConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceDeepDiveSystemConfiguration.class)
public class AspectWithAroundAdviceTest {
	@Autowired
	AspectWithAroundAdvice aroundAdvice;

	@Autowired
	DemoService service;

	@Before
	public void rest() {
		aroundAdvice.reset();
	}

	@Test
	public void aroundAdviceIsCalledForSimpleMethod() {
		assertFalse(aroundAdvice.isAroundAdviceCalled());
		service.example();
		assertTrue(aroundAdvice.isAroundAdviceCalled());
	}

	@Test(expected = RuntimeException.class)
	public void aroundAdviceIsCalledIfExceptionIsThrown() {
		assertFalse(aroundAdvice.isAroundAdviceCalled());
		try {
			service.throwsRunTimeExcep();
		} finally {
			assertTrue(aroundAdvice.isAroundAdviceCalled());
		}
	}

	@Test
	public void aroundAdviceIsCalledIfValueIsReturned() {
		assertFalse(aroundAdvice.isAroundAdviceCalled());
		assertThat(service.returnsString(), equalTo("dev value:::11"));
		assertTrue(aroundAdvice.isAroundAdviceCalled());
	}
}
