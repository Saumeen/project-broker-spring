package com.project.broker.service;

import java.util.List;

import com.project.broker.dto.UserAuth;

public interface UserService {
	
	public UserAuth isLoginUser(UserAuth userauth);
	public boolean isUserExits(UserAuth userauth);
	
	public UserAuth addUser(UserAuth userAuth) throws Exception;

}
