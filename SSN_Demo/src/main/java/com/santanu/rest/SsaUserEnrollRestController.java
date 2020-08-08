package com.santanu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santanu.model.SsaUserRequest;
import com.santanu.service.SsaService;

@RestController
public class SsaUserEnrollRestController {
	
	@Autowired
	private SsaService ssaService;
	
	@PostMapping(
				
				value="/ssnEnrollment",
				consumes="application/json"
			)
	public ResponseEntity<String> ssnEnroll(@RequestBody SsaUserRequest ssaUserReq) throws Exception{
		//Declaring Variables
		ResponseEntity<String> response = null;
		String message = null;
		Long ssn = null;
		
		
		ssn = ssaService.enrollSsn(ssaUserReq);
		
		message="Your have enrolled successfully with SSN:"+ssn;
		
		response = new ResponseEntity<>(message,HttpStatus.CREATED); 
		
		return response;
		
	}
}
