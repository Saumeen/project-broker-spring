package com.project.broker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.broker.model.User;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, Long> {

	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username,String password);

}
