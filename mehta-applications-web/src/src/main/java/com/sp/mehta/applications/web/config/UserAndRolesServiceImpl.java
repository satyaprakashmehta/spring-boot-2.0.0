package com.sp.mehta.applications.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sp.mehta.applications.model.User;
import com.sp.mehta.applications.repository.RolesRepository;
import com.sp.mehta.applications.repository.UserRepository;

@Component
public class UserAndRolesServiceImpl implements UserDetailsService    {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if(userName==null || userName.isEmpty())
			throw new UsernameNotFoundException("Invalid/Empty UserName...");
		else{
			User user = userRepository.findByUserName(userName);
			if(user!=null){
				List<String> userRoles = rolesRepository.findAllRolesByUserId(user.getId());
				return new ApplicationUserDetails(user,userRoles);
			}
			else
				throw new UsernameNotFoundException("UserName Not Found...");
		}
	}
	
}
