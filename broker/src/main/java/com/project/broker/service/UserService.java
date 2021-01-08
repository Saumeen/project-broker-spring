package com.project.broker.service;

import com.project.broker.dto.UserAuth;


public interface UserService {
	
	public void addUser(UserAuth userAuth) throws  Exception;	
	
	public UserAuth isValid(String username,String password);
	
	

}
