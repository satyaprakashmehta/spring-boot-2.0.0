package com.sp.mehta.applications.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.mehta.applications.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {
	
	public List<Roles> findAll();
	
	@Query("SELECT R.role FROM Roles R where R.user.id=?1")
	public List<String> findAllRolesByUserId(Integer userId);
	
}
