package com.dev.springaop.repository;

import org.springframework.stereotype.Repository;

import com.dev.springaop.Domain.DomainObject;
@Repository
public class SimpleRepositoryImpl implements SimpleRepository {
	
	/* (non-Javadoc)
	 * @see com.dev.springaop.repository.SimpleRepository#findModelObject()
	 */
	public DomainObject findDomainObject(){
		return new DomainObject();
	}
}