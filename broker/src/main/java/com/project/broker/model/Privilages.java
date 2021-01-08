package com.project.broker.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privilages")
public class Privilages {
	@Id
	private String id;
	
	@Column(name = "privilage_name")
	private String privilageName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="privilaes")
	@DBRef
	private Role role;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrivilageName() {
		return privilageName;
	}
	public void setPrivilageName(String privilageName) {
		this.privilageName = privilageName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	

}
