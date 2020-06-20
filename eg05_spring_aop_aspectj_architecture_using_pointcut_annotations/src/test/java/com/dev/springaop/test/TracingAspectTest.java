package com.dev.springaop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.TracingAspect;
import com.dev.springaop.configuration.SystemConfigJava;
import com.dev.springaop.repository.DemoRepository;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfigJava.class)
public class TracingAspectTest {
	@Autowired
	private TracingAspect aroundTracingAspect;
	@Autowired
	private DemoService service;
	@Autowired
	private DemoRepository repository;
	
	@Before
	public void setup(){
		aroundTracingAspect.resetCalled();
	}
	@Test
	public void tracingIsCalledForService() {
	    assertFalse(aroundTracingAspect.isCalled());
	    service.example();
	    assertTrue(aroundTracingAspect.isCalled());
	  }
	@Test
	public void tracingIsCalledForRepositories() {
	    assertFalse(aroundTracingAspect.isCalled());
	    repository.example();
	    assertTrue(aroundTracingAspect.isCalled());
	  }
}
