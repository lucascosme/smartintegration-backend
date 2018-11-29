package com.lcsolution.smartIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.lcsolution.smartIntegration.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String userName);
}
