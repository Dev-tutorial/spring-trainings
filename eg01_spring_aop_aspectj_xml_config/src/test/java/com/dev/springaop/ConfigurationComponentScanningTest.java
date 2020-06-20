package com.dev.springaop;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.Domain.DomainObject;
import com.dev.springaop.service.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/component-scanning.xml")
public class ConfigurationComponentScanningTest {

	@Autowired
	private SimpleService service;

	@Test
	public void dependencyInjectionShouldWork() {
		assertNotNull(service);
	}

	@Test
	public void serviceShouldReturnDomainObject() {
		assertThat(service.findModelObject(), equalTo(new DomainObject()));
	}

}
