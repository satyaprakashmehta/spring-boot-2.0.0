package com.sp.mehta.applications.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.mehta.applications.common.vo.AddressVo;
import com.sp.mehta.applications.common.vo.UserVo;
import com.sp.mehta.applications.model.Address;
import com.sp.mehta.applications.model.User;
import com.sp.mehta.applications.repository.AddressRepository;
import com.sp.mehta.applications.repository.UserRepository;
import com.sp.mehta.applications.service.AddressService;

@Component
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Override
	public Integer createAddress(AddressVo addressVo) {
		if(addressVo != null) {
			Address address = new Address();
			address.setCity(addressVo.getCity());
			address.setState(addressVo.getState());
			address.setCountry(addressVo.getCountry());
			address.setPincode(addressVo.getPincode());
			
			User user = null;
			if(addressVo.getUserVo()!=null) {
				Integer userId = addressVo.getUserVo().getId();
				if(userId!=null) {
					user = userRepository.findOne(userId);
					if(user!=null) {
						address.setUser(user);
					}
				}
			}
			if(user==null) {
				logger.error("Invalid User ...!");
				return null;
			}
			address = addressRepository.save(address);
			
			if(address!=null && address.getId()!=null)
				return address.getId();
			
		}
		return null;
	}

	@Override
	public Boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressVo readAddress(Integer id) {
		AddressVo addressVo = null;

		if (id != null) {
			Address address = addressRepository.findOne(id);

			if (address != null) {
				addressVo = new AddressVo();
				addressVo.setCity(address.getCity());
				addressVo.setCountry(address.getCountry());
				addressVo.setPincode(address.getPincode());
				addressVo.setState(address.getState());

				UserVo userVo = new UserVo();
				userVo.setId(address.getUser().getId());
				userVo.setUserName(address.getUser().getUserName());
				
				addressVo.setUserVo(userVo);
				
				/* addressVo = new AddressVo(address); */

			}

		}

		return addressVo;
	}

	@Override
	public Boolean deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressVo> listAddress() {
		List<AddressVo> addressVoList = null;

		List<Address> addressList = (List<Address>) addressRepository.findAll();
		
		if(addressList !=null ) {
			addressVoList= new ArrayList<AddressVo>();
			AddressVo addressVo = null;
			
			for(Address address : addressList) {
				if (address != null) {
					addressVo = new AddressVo();
					addressVo.setCity(address.getCity());
					addressVo.setCountry(address.getCountry());
					addressVo.setPincode(address.getPincode());
					addressVo.setState(address.getState());

					UserVo userVo = new UserVo();
					userVo.setId(address.getUser().getId());
					userVo.setUserName(address.getUser().getUserName());
					
					addressVo.setUserVo(userVo);
					
					addressVoList.add(addressVo);
					
				}
			}
			
		}
		
		return addressVoList;
	}

}
