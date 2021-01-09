package com.project.broker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.broker.dto.RoleDto;
import com.project.broker.model.Privilege;
import com.project.broker.model.Role;
import com.project.broker.repository.PrivilegeRepository;
import com.project.broker.repository.RoleRepository;
import com.project.broker.service.RolePrivilageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolePrivilageServiceImpl implements RolePrivilageService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepo;
	
	@Override
	public void addRole(RoleDto roleDto) {
		
		Role role= roleRepository.findByRoleName(roleDto.getRoleName());
		if(role == null ) {
			role = new Role();
			role.setRoleName(roleDto.getRoleName());
			for(String pri :roleDto.getPrivilages()){
				Privilege privilegeTemp = privilegeRepo.findByPrivilageName(pri);
				if(privilegeTemp == null) {
					privilegeTemp = new Privilege();
					
					privilegeTemp.setPrivilageName(pri);
					role.addPrivilege(privilegeTemp);
					
				}
				else {
					role.addPrivilege(privilegeTemp);
				}
				
				log.info("{}",role.getPrivilege().toArray());
			}
			roleRepository.save(role);
		}
		
		//roleRepository.save(role);
		
		

//		try {
//
//			Role roleDtoTemp = roleRepository.findByRoleName(roleDto.getRoleName());
//			if (roleDtoTemp == null) {
//				roleDtoTemp = new Role();
//				roleDtoTemp.setRoleName(roleDto.getRoleName());
//				//roleDtoTemp.setPrivilege(roleDtoTemp.getPrivilege());
//				roleRepository.save(roleDtoTemp);
//
//			}
//
//			Role save = roleRepository.save(roleDtoTemp);
//			log.info("Saved Role :: {}  List :: {}", save.toString(), save.getPrivilege());
//
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
	}

	@Override
	public List<RoleDto> getAllRoles() {
		return null;

		
	}

	@Override
	public List<String> getPrivilageByRole(String roleName) {
		return null;
		
		
	}

}
