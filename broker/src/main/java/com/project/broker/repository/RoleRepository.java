package com.project.broker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.broker.model.Role;

@EnableMongoRepositories
public interface RoleRepository extends MongoRepository<Role,String>{

	public Role findByRoleName(String roleName);
	
}
