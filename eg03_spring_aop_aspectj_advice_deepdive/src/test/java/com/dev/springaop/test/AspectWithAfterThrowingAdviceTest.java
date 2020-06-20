package com.dev.springaop.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AspectWithAfterThrowingAdvice;
import com.dev.springaop.configuration.AdviceDeepDiveSystemConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceDeepDiveSystemConfiguration.class)
public class AspectWithAfterThrowingAdviceTest {
	@Autowired
	AspectWithAfterThrowingAdvice afterThrowingAdvice;

	@Autowired
	DemoService service;

	@Before
	public void reset() {
		afterThrowingAdvice.reset();
	}
	
	@Test
	public void afterThrowingIsNotCalledIfMethodReturnSuccessfully() {
		assertFalse(afterThrowingAdvice.isAfterThrowingAdviceCalled());
		service.example();
		assertFalse(afterThrowingAdvice.isAfterThrowingAdviceCalled());
	}

	@Test(expected = RuntimeException.class)
	public void afterThrowingIsCalledIfMethodThrowsRuntimeException() {
		assertFalse(afterThrowingAdvice.isAfterThrowingAdviceCalled());
		try {
			service.throwsRunTimeExcep();
		} finally {
			assertTrue(afterThrowingAdvice.isAfterThrowingAdviceCalled());
		}
	}

  @Test(expected = Exception.class)	
	 public void afterThrowingIsNotCalledIfMethodThrowsException() throws Exception {
	    assertFalse(afterThrowingAdvice.isAfterThrowingAdviceCalled());
	    try {
	      service.throwsException();
	    } finally {
	      assertFalse(afterThrowingAdvice.isAfterThrowingAdviceCalled());
	    }
	  }
}
