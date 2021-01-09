package com.project.broker.service;

import java.util.List;
import java.util.Optional;

import com.project.broker.dto.RoleDto;
import com.project.broker.model.Role;

public interface RolePrivilageService {

	/**
	 * Adding role
	 * @param roleDtos
	 */
	public void addRole(RoleDto roleDtos);
	
	/**
	 * Get all the roles exits in system
	 * @return
	 */
	public List<RoleDto> getAllRoles();
	
	/**
	 * Get privilege of specific role
	 * @param role
	 * @return
	 */
	public List<String> getPrivilageByRole(String role);
	
	

}
