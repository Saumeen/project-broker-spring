//package com.project.broker.service.impl;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.project.broker.dto.RoleDto;
//import com.project.broker.dto.UserAuth;
//import com.project.broker.exception.CustomRuntimeException;
//import com.project.broker.model.Role;
//import com.project.broker.model.User;
//import com.project.broker.repository.RoleRepository;
//import com.project.broker.repository.UserRepository;
//import com.project.broker.service.RolePrivilageService;
//import com.project.broker.service.UserService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class UserServiceImpl implements UserService {
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	RoleRepository roleRepository;
//
//	@Autowired
//	RolePrivilageService rolePrivilageService;
//
//	@Override
//	public void addUser(UserAuth userAuth) {
//		User user = userRepository.findByUsername(userAuth.getUsername());
//
//		if (user == null) {
//			User usertemp = new User();
//			usertemp.setEmail(userAuth.getEmail());
//			usertemp.setUsername(userAuth.getUsername());
//			usertemp.setPassword(new BCryptPasswordEncoder().encode(userAuth.getPassword()));
//
//			Role role = roleRepository.findByRoleName(userAuth.getRoleName());
//
//			if (role != null) {
//				usertemp.setRole(new HashSet<>(Arrays.asList(role)));
//				userRepository.save(usertemp);
////				role.getUsers().add(usertemp);
////				role.setUsers(role.getUsers());
//				roleRepository.save(role);
//				
//			}
//			else {
//				throw new CustomRuntimeException("Role not Exits !!");
//			}
//
//		} else {
//			throw new CustomRuntimeException("User Exits Already!!");
//		}
//
//	}
//
//	@Override
//	public UserAuth isValid(String username, String password) {
//
//		log.info("Username :: {} pasword :: {} encoed pasword --> {}", username, password);
//		User user = userRepository.findByUsername(username);
//
//		if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
//			UserAuth userAuth = new UserAuth();
//			userAuth.setUsername(user.getUsername());
//			userAuth.setEmail(user.getEmail());
//			return userAuth;
//		}
//		return null;
//
//	}
//
//}
