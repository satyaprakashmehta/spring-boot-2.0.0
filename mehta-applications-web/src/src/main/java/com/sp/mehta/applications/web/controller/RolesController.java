package com.sp.mehta.applications.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mehta.applications.common.constants.ApplicationConstants;
import com.sp.mehta.applications.common.util.ResponseBuilder;
import com.sp.mehta.applications.common.vo.RolesVo;
import com.sp.mehta.applications.service.RolesService;

@RestController
@RequestMapping(value=ApplicationConstants.OPERATION_ROLES)
public class RolesController {

	@Autowired
	RolesService rolesService;
	
	@RequestMapping(value = ApplicationConstants.OPERATION_CREATE, method = RequestMethod.POST)
	public Object createRoles(@RequestBody RolesVo rolesVo) {
		
		Integer id = rolesService.createRoles(rolesVo, "1001");
		
		if(id!=null && id>0)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).id(id).build();
	}
	
	@RequestMapping(value = ApplicationConstants.OPERATION_READ, method = RequestMethod.GET)
	public Object readRoles(@PathVariable Integer id) {
		
		Object result = rolesService.readRoles(id, "1001");
		
		if(result!=null)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).object(result).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).object(result).build();
	}
	
	@RequestMapping(value = ApplicationConstants.OPERATION_LIST, method = RequestMethod.GET)
	public Object listtest() {
		
		Object result = rolesService.listRoles();
		
		if(result!=null)
			return new ResponseBuilder().status(ResponseBuilder.Status.success).object(result).build();
		
		return new ResponseBuilder().status(ResponseBuilder.Status.error).object(result).build();
	}
}
