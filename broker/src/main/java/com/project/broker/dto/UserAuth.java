package com.project.broker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserAuth {

	private String username;
	
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String password;
	
	
}
