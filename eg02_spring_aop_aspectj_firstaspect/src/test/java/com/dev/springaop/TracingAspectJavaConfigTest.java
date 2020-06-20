package com.dev.springaop;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.TracingAspect;
import com.dev.springaop.configuration.FirstAspectConfiguration;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=FirstAspectConfiguration.class)
public class TracingAspectJavaConfigTest {
	@Autowired
	DemoService service;
	@Autowired
	TracingAspect trace;
	@Test
	public void tracingAspectIsCalled(){
		assertFalse(trace.isEnterCalled());
		service.exampleWithNoParameter();
		service.example(10);
		assertTrue(trace.isEnterCalled());
	}
}
