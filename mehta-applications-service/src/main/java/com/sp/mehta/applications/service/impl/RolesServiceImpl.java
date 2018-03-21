package com.sp.mehta.applications.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.mehta.applications.common.vo.RolesVo;
import com.sp.mehta.applications.model.Roles;
import com.sp.mehta.applications.model.User;
import com.sp.mehta.applications.repository.RolesRepository;
import com.sp.mehta.applications.repository.UserRepository;
import com.sp.mehta.applications.service.RolesService;

@Component
public class RolesServiceImpl implements RolesService    {

	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Integer createRoles(RolesVo rolesVo, String rolesId) {
		if(rolesVo!=null){
			Roles roles = new Roles();
			User user = null;
			if(rolesVo.getUserId()!=null) {
				user = userRepository.findOne(rolesVo.getUserId());
				if(user!=null)
					roles.setUser(user);
			}
			
			roles.setRole(rolesVo.getRole());
			roles.setActive(rolesVo.getActive());
			roles = rolesRepository.save(roles);
			if(roles.getId()!=null)
				return roles.getId();
		}
		return null;
	}

	@Override
	public RolesVo readRoles(Integer id, String rolesId) {
		Roles roles = rolesRepository.findOne(id);
		RolesVo rolesVo = null;
		if(roles!=null){
			rolesVo = new RolesVo(roles.getId());
			if(roles.getUser()!=null)
				rolesVo.setUserId(roles.getUser().getId());
			rolesVo.setRole(roles.getRole());
			rolesVo.setActive(roles.getActive());
		}
		return rolesVo; 
	}

	@Override
	public Integer updateRoles(RolesVo rolesVo, String userId) {
		return null;
	}

	@Override
	public List<RolesVo> listRoles() {
		List<Roles> rolesList  = rolesRepository.findAll();
		List<RolesVo> rolesVoList  = new ArrayList<RolesVo>();
		RolesVo rolesVo = null;
		if(rolesList!=null){
			for(Roles roles:rolesList){
				if(roles!=null){
					rolesVo = new RolesVo(roles.getId());
					if(roles.getUser()!=null)
						rolesVo.setUserId(roles.getUser().getId());
					rolesVo.setRole(roles.getRole());
					rolesVo.setActive(roles.getActive());
					rolesVoList.add(rolesVo);
				}
			}
		}
		return rolesVoList;
	}
	
		
}
