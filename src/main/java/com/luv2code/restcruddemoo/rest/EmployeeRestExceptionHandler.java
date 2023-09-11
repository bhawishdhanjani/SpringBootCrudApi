package com.luv2code.restcruddemoo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(RuntimeException exception){
		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		employeeErrorResponse.setMessage(exception.getMessage());
		employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(employeeErrorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
