package com.dev.springaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
	public void example(){
		
	}
	public void throwsException() {
		throw new RuntimeException();
	}
}
