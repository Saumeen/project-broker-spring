/**
 * 
 */
package com.project.broker.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.broker.constant.Constant.*;

import com.project.broker.dto.ResponseDTO;
import com.project.broker.dto.UserAuth;
import com.project.broker.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author saumeen
 *
 */

@RestController
@RequestMapping("/auth")
@Slf4j
public class AutheticationController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<ResponseDTO> signupDetails(@RequestBody UserAuth userAuth) {
		log.info("Executing addItem method");
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {

			UserAuth user = userService.addUser(userAuth);

			map.put(RESPONSE, user);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(HttpStatus.OK.value(), true, ADDED_MEG, map));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(HttpStatus.OK.value(), false, e.getMessage(), map));

		}
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> loginDetails(@RequestBody UserAuth userAuth) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String message;
		try {

			UserAuth user = userService.isLoginUser(userAuth);
			log.info(user.toString());
			if (user.isExits()) {
				message = USER_EXITS;
			} else {
				message = USER_NOT_EXITS;
			}
			map.put(RESPONSE, user);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(HttpStatus.OK.value(), true, message, map));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(HttpStatus.OK.value(), false, e.getMessage(), map));

		}
	}
}
