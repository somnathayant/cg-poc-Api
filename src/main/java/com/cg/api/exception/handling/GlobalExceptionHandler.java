package com.cg.api.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ResourceNotSavedException.class)
	public ResponseEntity<?> handleResourceNotSaved(final ResourceNotSavedException exception,
			final HttpServletRequest request) {

		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
