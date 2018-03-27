package com.sp.mehta.applications.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.mehta.applications.model.User;

public interface TestRepository extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u")
	public Object findAllUser();

}
