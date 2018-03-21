package com.sp.mehta.applications.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mehta.applications.common.constants.ApplicationConstants;
import com.sp.mehta.applications.service.UserService;

@RestController
public class WelcomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = ApplicationConstants.OPERATION_WELCOME, method = RequestMethod.GET)
	public Object welcomeMessage() {
		
		return "Welcome user...";
	}

}
