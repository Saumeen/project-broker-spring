package com.project.broker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "bk_ip_location")
public class IpLocationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ipAddres;
	private String uri;
	
	
	
	

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the ipAddres
	 */
	public String getIpAddres() {
		return ipAddres;
	}

	/**
	 * @param ipAddres the ipAddres to set
	 */
	public void setIpAddres(String ipAddres) {
		this.ipAddres = ipAddres;
	}
	
	
	

}
