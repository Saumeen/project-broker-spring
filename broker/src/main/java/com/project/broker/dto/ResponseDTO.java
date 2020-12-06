package com.project.broker.dto;

import java.util.Map;

import lombok.Data;

/**
 * 
 * Use DTO to send response of the all request.
 * 
 * @author Montej Shah
 *
 */
@Data
public class ResponseDTO {
	private int status;
	private boolean success;
	private String message;
	private Map<String, Object> data;

	public ResponseDTO(int status, boolean success, String message, Map<String, Object> data) {
		super();
		this.status = status;
		this.success = success;
		this.message = message;
		this.data = data;
	}

}