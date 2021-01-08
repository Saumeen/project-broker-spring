package com.project.broker.service;

import java.util.List;
import java.util.Optional;

import com.project.broker.dto.RoleDto;

public interface RolePrivilageService {

	public void addRole(RoleDto roleDtos);
	
	public List<RoleDto> getAllRoles();
	
	public Optional<RoleDto> getPrivilageByRole(String role);
	
	

}
