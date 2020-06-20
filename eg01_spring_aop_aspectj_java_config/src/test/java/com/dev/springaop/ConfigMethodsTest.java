package com.dev.springaop;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev.springaop.Domain.DomainObject;
import com.dev.springaop.service.SimpleService;

import configuration.SystemConfigMethos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfigMethos.class)
public class ConfigMethodsTest {

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
