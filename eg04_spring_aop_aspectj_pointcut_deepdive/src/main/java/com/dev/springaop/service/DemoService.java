package com.dev.springaop.service;

import org.springframework.stereotype.Service;

import com.dev.springaop.annotation.Trace;

@Service
public class DemoService {
	
	public void demoExample(){
		
	}
	@Trace
	public void annotatedExample(){
		
	}
}
