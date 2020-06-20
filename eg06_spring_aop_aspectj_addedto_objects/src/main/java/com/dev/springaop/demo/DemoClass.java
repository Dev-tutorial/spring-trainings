package com.dev.springaop.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoClass {
	
	public void example(){
		
	}
	public void callsTheExampleMethod(){
		example();
	}
}
