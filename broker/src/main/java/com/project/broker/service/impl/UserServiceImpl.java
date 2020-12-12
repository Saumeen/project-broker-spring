package com.project.broker.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public boolean isUserExits(UserAuth userAuth) {

		boolean isExits = false;
		try {
			User user = userRepository.findByUserNameAndPassWord(userAuth.getUsername(), userAuth.getPassword());
			log.info("Found :: " + user.toString());

			if (user != null) {
				isExits = true;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return isExits;
	}

	@Override
	public UserAuth addUser(UserAuth userAuth) throws Exception {
		User user = userRepository.findByUserNameAndPassWord(userAuth.getUsername(), userAuth.getPassword());

		if (user == null) {
			User usertemp = new User();
			usertemp.setEmail(userAuth.getEmail());
			usertemp.setUserName(userAuth.getUsername());
			usertemp.setPassWord(userAuth.getPassword());
			userRepository.save(usertemp);
		}else {	
				throw new Exception("User Exits Already!!");
		}
		return userAuth;

	}

	@Override
	public UserAuth isLoginUser(UserAuth userAuth) {
		UserAuth userAuthExits = new UserAuth();

		if (isUserExits(userAuth)) {
			userAuthExits.setUsername(userAuth.getUsername());
			userAuthExits.setEmail(userAuth.getEmail());
			userAuthExits.setExits(true);
		} else {
			userAuthExits.setExits(false);
		}

		return userAuthExits;
	}

}
