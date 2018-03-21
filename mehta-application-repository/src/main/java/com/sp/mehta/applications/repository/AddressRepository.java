package com.sp.mehta.applications.repository;

import org.springframework.data.repository.CrudRepository;

import com.sp.mehta.applications.model.Address;

public interface AddressRepository extends CrudRepository<Address,Integer>{

	
}
