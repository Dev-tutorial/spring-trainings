package com.dev.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.springaop.Domain.DomainObject;
import com.dev.springaop.repository.SimpleRepository;

@Service
public class SimpleService {
	@Autowired
	SimpleRepository repo;
	
	public DomainObject findModelObject(){
		return repo.findDomainObject();
	}
}
