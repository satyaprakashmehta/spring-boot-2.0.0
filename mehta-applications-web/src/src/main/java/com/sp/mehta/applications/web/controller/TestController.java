package com.sp.mehta.applications.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mehta.applications.common.constants.ApplicationConstants;
import com.sp.mehta.applications.common.util.ResponseBuilder;
import com.sp.mehta.applications.service.TestService;

@RestController
@RequestMapping(value=ApplicationConstants.OPERATION_TEST)
public class TestController {

	@Autowired
	TestService testService;
	

	@RequestMapping(value = ApplicationConstants.OPERATION_LIST, method = RequestMethod.GET)
	public Map<String,Object> listtest() {
		
		Object result = testService.testList();
		
		if(result!=null)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).object(result).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).object(result).build();
	}
}
