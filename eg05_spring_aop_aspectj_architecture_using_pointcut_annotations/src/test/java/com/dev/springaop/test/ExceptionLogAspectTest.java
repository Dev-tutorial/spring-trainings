package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.ExceptionLogAspect;
import com.dev.springaop.configuration.SystemConfigJava;
import com.dev.springaop.repository.DemoRepository;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfigJava.class)
public class ExceptionLogAspectTest {
	@Autowired
	private ExceptionLogAspect exceptionLogAspect;
	@Autowired
	private DemoService service;
	@Autowired
	private DemoRepository repository;
	
	@Before
	public void setup(){
		exceptionLogAspect.resetCalled();
	}
	
	@Test
	public void exceptionLoggingIsNotCalledIfNoExceptionIsThrown() {
		assertFalse(exceptionLogAspect.isCalled());
		repository.example();
		assertFalse(exceptionLogAspect.isCalled());
	}

	@Test(expected = RuntimeException.class)
	public void exceptionLoggingIsCalledIfExceptionIsThrown() {
		assertFalse(exceptionLogAspect.isCalled());
		try {
			repository.throwsException();
		} finally {
			assertTrue(exceptionLogAspect.isCalled());
		}
	}
	
}
