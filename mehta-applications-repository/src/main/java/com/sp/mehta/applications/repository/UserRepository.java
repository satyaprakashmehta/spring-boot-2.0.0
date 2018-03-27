package com.sp.mehta.applications.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sp.mehta.applications.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserName(String userName);
	
	public List<User> findAll();

}
