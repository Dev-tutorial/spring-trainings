package com.dev.springaop.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.aspect.TracingAspect;
import com.dev.springaop.configuration.SystemConfiguration;
import com.dev.springaop.demo.DemoClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SystemConfiguration.class)
public class TracingAspectTest {
	@Autowired
	private DemoClass demoClass;
	@Autowired
	private TracingAspect tracingAspect;
	
	@Before
	public void setup(){
		tracingAspect.resetCalled();
	}
	
	@Test
	public void directCallToexampleTraced(){
		assertFalse(tracingAspect.isCalled());
		demoClass.example();
		assertTrue(tracingAspect.isCalled());
	}
	@Test
	public void indirectCallToExampleNotTraced(){
		assertFalse(tracingAspect.isCalled());
		demoClass.callsTheExampleMethod();
		assertFalse(tracingAspect.isCalled());
	}
}
