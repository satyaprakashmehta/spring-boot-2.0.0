package com.sp.mehta.applications.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mehta.applications.common.constants.ApplicationConstants;
import com.sp.mehta.applications.common.util.ResponseBuilder;
import com.sp.mehta.applications.common.vo.UserVo;
import com.sp.mehta.applications.service.UserService;

@RestController
@RequestMapping(value=ApplicationConstants.OPERATION_USER)
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = ApplicationConstants.OPERATION_CREATE, method = RequestMethod.POST)
	public Object userCreate(@RequestBody UserVo userVo) {
		
		if(userVo!=null && userVo.getPassword()!=null)
		userVo.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));
		Integer id = userService.createUser(userVo, "1001");
		
		if(id!=null && id>0)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).id(id).build();
	}
	
	@RequestMapping(value = ApplicationConstants.OPERATION_READ, method = RequestMethod.GET)
	public Object readUser(@PathVariable Integer id ) {
		
		UserVo userVo= userService.readUser(id, "1001");
		/*if(userVo!=null && userVo.getPassword()!=null)
			userVo.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));*/

		if(userVo!=null)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).object(userVo).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).object(userVo).build();
	}
	
	@RequestMapping(value = ApplicationConstants.OPERATION_LIST, method = RequestMethod.GET)
	public Object listUser() {
		
		Object result = userService.listUser();
		
		if(result!=null)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).object(result).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).object(result).build();
	}
}
