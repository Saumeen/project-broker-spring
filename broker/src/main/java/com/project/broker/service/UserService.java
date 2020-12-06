package com.project.broker.service;

import com.project.broker.dto.UserAuth;

public interface UserService {
	
	
	public UserAuth isUserExits(UserAuth userauth);
	
	public UserAuth addUser(UserAuth userAuth);

}
