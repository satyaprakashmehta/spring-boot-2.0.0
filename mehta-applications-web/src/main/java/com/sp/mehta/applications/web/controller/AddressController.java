package com.sp.mehta.applications.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mehta.applications.common.constants.ApplicationConstants;
import com.sp.mehta.applications.common.vo.AddressVo;
import com.sp.mehta.applications.service.AddressService;

@RestController
@RequestMapping(value = ApplicationConstants.OPERATION_ADDRESS)
public class AddressController {

	@Autowired
	AddressService addressService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	// inject via application.properties
	@Value("${mehta.welcome.message}")
	private String message;

	@RequestMapping(value = ApplicationConstants.OPERATION_READ, method = RequestMethod.GET)
	AddressVo readAddress(@PathVariable Integer id) {
		AddressVo addressVo = null;
		if (id != null) {
			addressVo = addressService.readAddress(id);
		}

		return addressVo;
	}

	@RequestMapping(value = ApplicationConstants.OPERATION_LIST, method = RequestMethod.GET)
	List<AddressVo> listAddress() {
		List<AddressVo> addressVoList = null;

		addressVoList = addressService.listAddress();

		return addressVoList;
	}
	
	@RequestMapping (value= ApplicationConstants.OPERATION_CREATE, method = RequestMethod.POST)
	Integer createAddress (@RequestBody AddressVo addressVo) {
		Integer id= null;
		logger.info(message);
		if (addressVo != null) {
			id = addressService.createAddress(addressVo);
		}
		
		return id;
		
	}
	
}
