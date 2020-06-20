package com.dev.springaop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.AnnotationAspect;
import com.dev.springaop.configuration.SystemJavaConfig;
import com.dev.springaop.service.DemoService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SystemJavaConfig.class)
public class AnnotationAspectTest {
	@Autowired
	AnnotationAspect traceAnnotationAspect;

	@Autowired
	DemoService service;

	@Before
	public void setUp() {
		traceAnnotationAspect.resetCalled();
	}

	@Test
	public void tracingOnNotAnnotatedMethodIsNotCalled() {
		assertEquals(traceAnnotationAspect.getCalled(), false);
		service.demoExample();
		assertEquals(traceAnnotationAspect.getCalled(), false);
	}

	@Test
	public void tracingOnAnnotatedMethodIsCalled() {
		assertEquals(traceAnnotationAspect.getCalled(), false);
		service.annotatedExample();
		assertEquals(traceAnnotationAspect.getCalled(), true);
	}
}
