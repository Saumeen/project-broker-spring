package com.project.broker.dto;

import lombok.Data;

@Data
public class UserAuth {

	private String username;
	private String email;
	private String password;
	private boolean isExits;
}
