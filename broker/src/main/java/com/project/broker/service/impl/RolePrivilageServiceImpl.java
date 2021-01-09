package com.project.broker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.broker.dto.RoleDto;
import com.project.broker.model.PrivilegeModel;
import com.project.broker.model.RoleModel;
import com.project.broker.model.UserRolePrivilegeModel;
import com.project.broker.repository.PrivilegeRepository;
import com.project.broker.repository.RoleRepository;
import com.project.broker.repository.UserRolePrivilegeRepository;
import com.project.broker.service.RolePrivilageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolePrivilageServiceImpl implements RolePrivilageService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepo;

	@Autowired
	private UserRolePrivilegeRepository userRolePrivilegeRepo;

	@Override
	public void addRole(RoleDto roleDto) {

		RoleModel role = roleRepository.findByRoleName(roleDto.getRoleName());
		if (role == null) {
			role = new RoleModel();
			role.setRoleName(roleDto.getRoleName());
			for (String pri : roleDto.getPrivilages()) {
				PrivilegeModel privilegeTemp = privilegeRepo.findByPrivilageName(pri);
				UserRolePrivilegeModel userRolePrivilegeModel = new UserRolePrivilegeModel();
				if (privilegeTemp == null) {

					privilegeTemp = new PrivilegeModel();
					privilegeTemp.setPrivilageName(pri);

					userRolePrivilegeModel.setPrivilage(privilegeTemp);

				} else {
					userRolePrivilegeModel.setPrivilage(privilegeTemp);

				}

				userRolePrivilegeModel.setRole(role);
				userRolePrivilegeRepo.save(userRolePrivilegeModel);

			}

		}

	}

}
