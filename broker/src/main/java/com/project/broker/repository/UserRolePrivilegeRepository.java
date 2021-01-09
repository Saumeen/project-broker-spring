package com.project.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.broker.model.UserRolePrivilegeModel;

@Repository
public interface UserRolePrivilegeRepository extends JpaRepository<UserRolePrivilegeModel, Long> {

}
