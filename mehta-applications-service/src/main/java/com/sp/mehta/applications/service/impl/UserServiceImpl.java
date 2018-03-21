package com.sp.mehta.applications.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.mehta.applications.common.vo.UserVo;
import com.sp.mehta.applications.model.User;
import com.sp.mehta.applications.repository.UserRepository;
import com.sp.mehta.applications.service.UserService;

@Component
public class UserServiceImpl implements UserService    {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Integer createUser(UserVo userVo, String userId) {
		if(userVo!=null){
			User user = new User();
			user.setUserName(userVo.getUserName());
			user.setPassword(userVo.getPassword());
			user.setEmail(userVo.getEmail());
			user.setActive(userVo.getActive());
			user = userRepository.save(user);
			if(user.getId()!=null)
				return user.getId();
		}
		return null;
	}

	@Override
	public UserVo readUser(Integer id, String userId) {
		User user = userRepository.findOne(id);
		UserVo userVo = null;
		if(user!=null){
			userVo = new UserVo(user.getId());
			userVo.setUserName(user.getUserName());
			userVo.setPassword(user.getPassword());
			userVo.setEmail(user.getEmail());
			userVo.setActive(user.getActive());
		}
		return userVo; 
	}
	
	@Override
	public Object listUser() {
		
		List<User> resultObject = userRepository.findAll();
		return resultObject;
	}

	@Override
	public Integer updateUser(UserVo testVo, String userId) {
		return null;
	}
	
}
