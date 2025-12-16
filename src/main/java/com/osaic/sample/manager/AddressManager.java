package com.osaic.sample.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osaic.sample.dto.AddressDto;
import com.osaic.sample.sql.repository.AddressRepository;
import com.osaic.sample.util.AddressMapper;

@Service
public class AddressManager {

	@Autowired
	private AddressRepository addressResposity;

	public void saveAddress(AddressDto addressDto) {
		addressResposity.save(AddressMapper.toEntity(addressDto));
	}

	public AddressDto fetchAddress(final Integer addressId) {
		return AddressMapper.toDto(addressResposity.findById(addressId)
				.orElseThrow(() -> new IllegalStateException("Cannot find address with Id:" + addressId)));
	}

	public List<AddressDto> findAllAdress() {
		return addressResposity.findAll().stream().map(address -> AddressMapper.toDto(address))
				.collect(Collectors.toList());
	}

}
