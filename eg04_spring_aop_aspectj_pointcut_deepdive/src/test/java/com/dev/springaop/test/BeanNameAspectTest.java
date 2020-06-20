package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.BeanNameAspect;
import com.dev.springaop.configuration.SystemJavaConfig;
import com.dev.springaop.repository.DemoRepository;
import com.dev.springaop.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SystemJavaConfig.class)
public class BeanNameAspectTest {
	@Autowired
	private BeanNameAspect beanNameAspect;
	@Autowired
	private DemoService service;
	@Autowired
	private DemoRepository repository;
	@Before
	public void setup(){
		beanNameAspect.resetCalled();
	}
	@Test
	public void tracingOnServiceIsCalled(){
		assertEquals(beanNameAspect.getCalled(), false);
		service.demoExample();
		assertEquals(beanNameAspect.getCalled(), true);
	}
	@Test
	public void tracingOnRepsositoryIsNotCalled(){
		assertEquals(beanNameAspect.getCalled(), false);
		repository.demoExample();
		assertEquals(beanNameAspect.getCalled(), false);
	}
}
