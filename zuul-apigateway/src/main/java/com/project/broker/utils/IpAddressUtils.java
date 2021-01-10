package com.project.broker.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class IpAddressUtils {
	
	private HttpServletRequest request;
	
	private Logger log = LoggerFactory.getLogger(IpAddressUtils.class);
	
	@Autowired
	public IpAddressUtils(HttpServletRequest request) {
		this.request = request;
	}

	public String getIpAddress() {
		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");

			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}

		log.info("Remote address is ::: {}", remoteAddr);
		return remoteAddr;
	}

}
