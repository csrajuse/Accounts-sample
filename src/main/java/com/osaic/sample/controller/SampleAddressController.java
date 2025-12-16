package com.osaic.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osaic.sample.dto.AddressDto;
import com.osaic.sample.manager.AddressManager;

@RestController
public class SampleAddressController {

	@Autowired
	private AddressManager addressManager;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World from eclipse";
	}

	@PostMapping("/address")
	public ResponseEntity<String> createPerson(@RequestBody AddressDto addressDto) {

		addressManager.saveAddress(addressDto);

		return new ResponseEntity<String>("Address Created.", HttpStatus.CREATED);
	}

	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDto>> findAllPeople() {
		return new ResponseEntity<List<AddressDto>>(addressManager.findAllAdress(), HttpStatus.FOUND);
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<AddressDto> findAddress(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<AddressDto>(addressManager.fetchAddress(id), HttpStatus.FOUND);
		} catch (IllegalStateException ile) {
			return new ResponseEntity<AddressDto>(HttpStatus.NOT_FOUND);
		}
	}
}
