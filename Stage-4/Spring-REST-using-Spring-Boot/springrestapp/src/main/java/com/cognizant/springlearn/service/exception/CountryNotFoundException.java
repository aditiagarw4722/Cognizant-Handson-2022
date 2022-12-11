package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Country not found")
public class CountryNotFoundException extends Exception{

	public CountryNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		//super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
