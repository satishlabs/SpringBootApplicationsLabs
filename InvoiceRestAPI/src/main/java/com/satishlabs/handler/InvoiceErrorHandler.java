package com.satishlabs.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.satishlabs.entity.ErrorType;
import com.satishlabs.exception.InvoiceNotFoundException;

@RestControllerAdvice
public class InvoiceErrorHandler {
	
	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<ErrorType> handleNotFound(InvoiceNotFoundException nfe){
		
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(), 
						"404- NOT FOUND", 
						nfe.getMessage()), 
				HttpStatus.NOT_FOUND);
	}
}
