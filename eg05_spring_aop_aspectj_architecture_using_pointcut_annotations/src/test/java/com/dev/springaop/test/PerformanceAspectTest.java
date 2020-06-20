package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.PerformanceAspect;
import com.dev.springaop.configuration.SystemConfigJava;
import com.dev.springaop.repository.DemoRepository;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfigJava.class)
public class PerformanceAspectTest {
	@Autowired
	private PerformanceAspect performanceAspect;
	@Autowired
	private DemoService service;
	@Autowired
	private DemoRepository repository;
	
	@Before
	public void setup(){
		performanceAspect.resetCalled();
	}

	@Test
	public void performanceIsCalledForRepositories() {
		assertFalse(performanceAspect.isCalled());
		repository.example();;
		assertTrue(performanceAspect.isCalled());
	}

	@Test
	public void performanceIsNotCalledForServices() {
		assertFalse(performanceAspect.isCalled());
		service.example();
		assertFalse(performanceAspect.isCalled());
	}
}
