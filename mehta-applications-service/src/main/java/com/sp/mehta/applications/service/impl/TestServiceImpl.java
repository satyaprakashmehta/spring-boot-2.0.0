package com.sp.mehta.applications.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.mehta.applications.repository.TestRepository;
import com.sp.mehta.applications.service.TestService;

@Component
public class TestServiceImpl implements TestService    {

	@Autowired
	TestRepository testRepository;
	
	@Override
	public Object testList() {
		Object userList  = testRepository.findAllUser();
		return userList;
	}
	
		
}
