package com.project.broker.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.broker.dto.RoleDto;
import com.project.broker.model.Privilages;
import com.project.broker.model.Role;
import com.project.broker.repository.PrivilageRepository;
import com.project.broker.repository.RoleRepository;
import com.project.broker.service.RolePrivilageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolePrivilageServiceImpl implements RolePrivilageService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilageRepository privilageRepository;

	@Override
	public void addRole(RoleDto roleDto) {

		Role role = new Role();
		Set<Privilages> privilageSet = new HashSet<>();

		role.setRoleName(roleDto.getRoleName());
		roleRepository.save(role);

		roleDto.getPrivilages().stream().forEach(privilage -> {
			Privilages privilageExits = privilageRepository.findByPrivilageName(privilage);
			if (privilageExits == null) {
				Privilages pre = new Privilages();
				pre.setPrivilageName(privilage);
				pre.setRole(role);
				log.info("Privilages -> {}", privilage);
				privilageSet.add(pre);
				privilageRepository.save(pre);
			} else {
				privilageSet.add(privilageExits);
			}

		});

		role.setPrivilaes(privilageSet);

		Role save = roleRepository.save(role);
		log.info("Saved Role :: {}  List :: {}", save.toString(), save.getPrivilaes());

	}

	@Override
	public List<RoleDto> getAllRoles() {

		List<RoleDto> roleDtos = new ArrayList<>();

		List<Role> allRole = roleRepository.findAll();
		allRole.forEach(role -> {
			Set<String> privilegeList = new HashSet<>();
			roleDtos.add(getPrivilageByRole(role, privilegeList).get());
		});

		return roleDtos;
	}

	@Override
	public Optional<RoleDto> getPrivilageByRole(String roleName) {
		Set<String> privilegeList = new HashSet<>();
		Role role = roleRepository.findByRoleName(roleName);
		if (role == null)
			return Optional.empty();
		return getPrivilageByRole(role, privilegeList);
	}

	private Optional<RoleDto> getPrivilageByRole(Role role, Set<String> privilageList) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(role.getRoleName());
		Set<Privilages> privilaes = role.getPrivilaes();
		privilaes.forEach(pre -> privilageList.add(pre.getPrivilageName()));
		roleDto.setPrivilages(privilageList);
		return Optional.of(roleDto);
	}

}
