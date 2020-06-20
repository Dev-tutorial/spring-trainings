package com.dev.springaop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.ClassNameAspect;
import com.dev.springaop.configuration.SystemJavaConfig;
import com.dev.springaop.repository.DemoRepository;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SystemJavaConfig.class)
public class ClassNameAspectTest {

	@Autowired
	ClassNameAspect aroundTracingAspect;

	@Autowired
	DemoService service;

	@Autowired
	DemoRepository repository;
	
	@Before
	public void setUp() {
		aroundTracingAspect.resetCalled();
	}

	@Test
	public void tracingOnServiceIsCalled() {
		assertEquals(aroundTracingAspect.getCalled(), false);
		service.demoExample();
		assertEquals(aroundTracingAspect.getCalled(), true);
	}
	
	@Test
	public void tracingOnRepsositoryIsNotCalled() {
		assertEquals(aroundTracingAspect.getCalled(), false);
		repository.demoExample();
		assertEquals(aroundTracingAspect.getCalled(), false);
	}
}
