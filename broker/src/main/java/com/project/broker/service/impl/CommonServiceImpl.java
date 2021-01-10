package com.project.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.broker.dto.IpDto;
import com.project.broker.model.IpLocationModel;
import com.project.broker.repository.IpLocationRepository;
import com.project.broker.security.IpAddressUtils;
import com.project.broker.service.CommonService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

	@Autowired
	private IpLocationRepository ipLocationRepo;

	@Autowired
	private IpAddressUtils ipAddressUtils;

	@Override
	public String setIpAddress(IpDto ipDto) {


		IpLocationModel ipLocationModel = new IpLocationModel();
		ipLocationModel.setIpAddres(ipDto.getIpAddress());
		ipLocationModel.setUri(ipDto.getUri());
		ipLocationRepo.save(ipLocationModel);

		return ipDto.getIpAddress();
	}

}
