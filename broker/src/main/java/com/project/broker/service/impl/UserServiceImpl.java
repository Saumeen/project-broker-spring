package com.project.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.broker.dto.UserAuth;
import com.project.broker.model.User;
import com.project.broker.repository.UserRepository;
import com.project.broker.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserAuth isUserExits(UserAuth userAuth) {
		UserAuth userAuthExits = new UserAuth();
		try {
			User user = userRepository.findByUserNameAndPassWord(userAuth.getUsername(), userAuth.getPassword());
			log.info("Found :: "+user.toString());
			if (user != null) {
				userAuthExits.setUsername(user.getUserName());
				userAuthExits.setEmail(user.getEmail());
				userAuthExits.setExits(true);
				
			} else {
				userAuthExits.setExits(false);
			
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return userAuthExits;
	}

	@Override
	public UserAuth addUser(UserAuth userAuth) {
		User user = userRepository.findByUserNameAndPassWord(userAuth.getUsername(), userAuth.getPassword());
		
		if (user == null) {
			User usertemp = new User();
			usertemp.setEmail(userAuth.getEmail());
			usertemp.setUserName(userAuth.getUsername());
			usertemp.setPassWord(userAuth.getPassword());
			userRepository.save(usertemp);
		}
		return userAuth;

	}

}
