package com.dev.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public void example(){
		
	}
	public void differentExample(){
		
	}
	public void throwsRunTimeExcep(){
		System.out.println("throwsRuntimeException...");
		throw new RuntimeException();
	}
	public void throwsException() throws Exception {
		  System.out.println("throwsException...");
	    throw new Exception();
	}
	public String returnsString() {
		System.out.println("returnsString...");
		return "dev value:::11";
	}
	public int returnsInt() {
		System.out.println("returnsInt...");
		return 12;
	}
	public String returnsStringAndThrowsRuntimeException() {
		System.out.println("returnsStringAndThrowsRuntimeException...");
		throw new RuntimeException();
	}
}
