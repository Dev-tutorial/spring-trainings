package com.dev.springaop;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.Domain.DomainObject;
import com.dev.springaop.service.SimpleService;

import configuration.SystemConfigComponentScan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfigComponentScan.class)
public class ComponentScanTest {
	@Autowired
	SimpleService service;
	
	@Test
	public void dependencyInjectionWorking(){
		assertNotNull(service);
	}
	@Test
	public void serviceShouldReturnDomainObject(){
		assertThat(service.findModelObject(), equalTo(new DomainObject()));
	}
}
