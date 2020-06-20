package com.dev.springaop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AspectWithafterReturningAdvice;
import com.dev.springaop.configuration.AdviceDeepDiveSystemConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceDeepDiveSystemConfiguration.class)
public class AspectWithAfterReturningAdviceTest {
	@Autowired
	AspectWithafterReturningAdvice afterReturningAdvice;
	@Autowired
	DemoService service;

	  @Before
	  public void reset() {
	    afterReturningAdvice.reset();
	  }

	  @Test
	  public void afterReturningIsNotCalledIfReturnTypeDoesntMatch() {
	    assertFalse(afterReturningAdvice.isAfterReturningAdvice());
	    service.returnsInt();
	    assertFalse(afterReturningAdvice.isAfterReturningAdvice());
	  }

	  @Test
	  public void afterReturningIsCalledIfReturnTypeMatches() {
	    assertFalse(afterReturningAdvice.isAfterReturningAdvice());
	    service.returnsString();
	    assertTrue(afterReturningAdvice.isAfterReturningAdvice());
	  }
	  @Test(expected = RuntimeException.class)
	  public void afterReturningIsNotCalledIfExceptionIsThrown() {
	    assertFalse(afterReturningAdvice.isAfterReturningAdvice());
	    try {
	      service.returnsStringAndThrowsRuntimeException();
	    } finally {
	      assertFalse(afterReturningAdvice.isAfterReturningAdvice());
	    }
	  }
}
