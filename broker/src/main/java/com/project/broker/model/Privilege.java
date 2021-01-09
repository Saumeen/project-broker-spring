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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "privilege")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "privilege_id")
	private long privilegeIdPK;

	private String privilageName;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "role_privilege", joinColumns = @JoinColumn(name = "privilege_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Role> role = new HashSet<>();

	/**
	 * @return the privilegeIdPK
	 */
	public long getPrivilegeIdPK() {
		return privilegeIdPK;
	}

	/**
	 * @param privilegeIdPK the privilegeIdPK to set
	 */
	public void setPrivilegeIdPK(long privilegeIdPK) {
		this.privilegeIdPK = privilegeIdPK;
	}

	/**
	 * @return the privilageName
	 */
	public String getPrivilageName() {
		return privilageName;
	}

	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return role;
	}

	/**
	 * @param privilageName the privilageName to set
	 */
	public void setPrivilageName(String privilageName) {
		this.privilageName = privilageName;
	}



	

}
