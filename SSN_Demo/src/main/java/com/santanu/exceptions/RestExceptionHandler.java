package com.santanu.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value=SsnNotGeneratedException.class)
	public ResponseEntity<?> handleSsnNotGeneratedException() {
		
		ApiError error = new ApiError(400,"SSN not Generated",new Date());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value=InvalidSsnException.class)
	public ResponseEntity<?> handleInvalidSsnException() {
		
		ApiError error = new ApiError(400,"IN-VALID SSN",new Date());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
