package com.project.broker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleIdPK;

	@Column(name = "role_name")
	private String roleName;

	@ManyToMany(mappedBy = "role",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Privilege> privilege = new HashSet<>();
	
	
	/**
	 * @return the roleIdPK
	 */
	public long getRoleIdPK() {
		return roleIdPK;
	}

	/**
	 * @param roleIdPK the roleIdPK to set
	 */
	public void setRoleIdPK(long roleIdPK) {
		this.roleIdPK = roleIdPK;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the privilege
	 */
	public Set<Privilege> getPrivilege() {
		return privilege;
	}

	/**
	 * @param privilege the privilege to set
	 */
	public void addPrivilege(Privilege privilege) {
		this.privilege.add(privilege);
		privilege.getRole().add(this);
	}


}
