package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringrestappApplication;


@RestController
class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringrestappApplication.class);
	
	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Start");
		return "Hello World!!";
		
	}
	

}
