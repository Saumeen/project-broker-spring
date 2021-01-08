package com.project.broker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "users")
public class User {

	@Id
	private String userId;

	private String username;
	private String password;
	private String email;
	

}
