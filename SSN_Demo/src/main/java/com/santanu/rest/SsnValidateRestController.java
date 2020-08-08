package com.santanu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.santanu.service.SsaService;

@RestController
public class SsnValidateRestController {
	
	@Autowired
	private SsaService ssaService;
	
	@GetMapping(value="validateSSN/{ssn}/{stateName}")
	public ResponseEntity<String> validateSSN(@PathVariable("ssn") Long ssn,
											@PathVariable("stateName") String stateName) throws Exception{
		
		//Declaring Variables
		ResponseEntity<String> response = null;
		String enrollmentStatus =null;
		
		enrollmentStatus = ssaService.validateEnrollment(ssn, stateName);
		
		response = new ResponseEntity<>(enrollmentStatus,HttpStatus.OK);
		
		return response;
	}
}
