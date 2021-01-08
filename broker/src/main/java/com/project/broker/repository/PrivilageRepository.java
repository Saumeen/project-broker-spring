package com.project.broker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.broker.model.Privilages;

@EnableMongoRepositories
public interface PrivilageRepository extends MongoRepository<Privilages, Long> {

	public Privilages findByPrivilageName(String name);
}
