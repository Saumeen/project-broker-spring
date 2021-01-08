package com.project.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public void addUser(UserAuth userAuth) throws Exception {
		User user = userRepository.findByUsername(userAuth.getUsername());

		if (user == null) {
			User usertemp = new User();
			usertemp.setEmail(userAuth.getEmail());
			usertemp.setUsername(userAuth.getUsername());
			usertemp.setPassword(new BCryptPasswordEncoder().encode(userAuth.getPassword()));
			userRepository.save(usertemp);
		} else {
			throw new Exception("User Exits Already!!");
		}

	}

	@Override
	public UserAuth isValid(String username, String password) {

		log.info("Username :: {} pasword :: {} encoed pasword --> {}",username,password);
		
		User user = userRepository.findByUsername(username);
		
		if(user != null &&
			new BCryptPasswordEncoder().matches(password, user.getPassword())){
			UserAuth userAuth = new UserAuth();
			userAuth.setUsername(user.getUsername());
			userAuth.setEmail(user.getEmail());
			return userAuth;
		}
		 
		
		return null;

	}

//
//	@Override
//	public UserAuth addUser(UserAuth userAuth) throws Exception {
//		User user = userRepository.findByUsername(userAuth.getUsername());
//
//		if (user == null) {
//			User usertemp = new User();
//			usertemp.setEmail(userAuth.getEmail());
//			usertemp.setUsername(userAuth.getUsername());
//			usertemp.setPassword(userAuth.getPassword());
//			userRepository.save(usertemp);
//		} else {
//			throw new Exception("User Exits Already!!");
//		}
//		return userAuth;
//
//	}
//
//	@Override
//	public UserAuth isLoginUser(UserAuth userAuth) {
//		UserAuth userAuthExits = new UserAuth();
//		
//		if (userAuth.getOrigin().equals("Google")) {
//			//finding user if exits . if not than add into db.
//			User user = userRepository.findByGoogleId(userAuth.getGoogleId());
//			log.info("User :::" + user);
//			if (user == null) {
//				user = new User();
//				user.setEmail(userAuth.getEmail());
//				user.setGoogleId(userAuth.getGoogleId());
//				user.setImageUrl(userAuth.getImageUrl());
//				user.setOrigin(userAuth.getOrigin());
//				user.setUsername(userAuth.getUsername());
//				user.setIslogin(true);
//				userRepository.save(user);
//			}
//		} else {
//			User user = userRepository.findByUsernameAndPassword(userAuth.getUsername(), userAuth.getPassword());
//
//			if (user != null) {
//				userAuthExits.setUsername(user.getUsername());
//				userAuthExits.setEmail(user.getEmail());
//				userAuthExits.setExits(true);
//
//				user.setIslogin(true);
//				userRepository.save(user);
//			} else {
//				userAuthExits.setExits(false);
//			}
//		}
//
//		return userAuthExits;
//	}
//
//	@Override
//	public void logoutUser(UserAuth userAuth) {
//		User user = userRepository.findByUsername(userAuth.getUsername());
//		user.setIslogin(false);
//		userRepository.save(user);
//	}

}
