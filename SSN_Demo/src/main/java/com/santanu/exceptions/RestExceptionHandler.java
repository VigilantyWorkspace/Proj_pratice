package com.santanu.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value=SsnNotGeneratedException.class)
	public ResponseEntity handleSsnNotGeneratedException() {
		
		ApiError error = new ApiError(500,"SSN not Generated",new Date());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value=InvalidSsnException.class)
	public ResponseEntity handleInvalidSsnException() {
		
		ApiError error = new ApiError(400,"IN-VALID SSN",new Date());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
