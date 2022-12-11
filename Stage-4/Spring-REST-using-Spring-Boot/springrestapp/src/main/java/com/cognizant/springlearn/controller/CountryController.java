package com.cognizant.springlearn.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;
import java.util.Optional;
@RestController
public class CountryController {
	
	private ApplicationContext context;
	
	public CountryController(){
		System.out.println("CountryController Called");
		
	}

	@RequestMapping("/country")
	public Country getCountryIndia() {
		context = new ClassPathXmlApplicationContext("country.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		context = new ClassPathXmlApplicationContext("country.xml"); 
		List<Country> country = (List<Country>)  context.getBean("countryList", List.class);
		return country;	
	}

	@GetMapping("/countries/{code}")
	public Optional<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		CountryService countryService = new CountryService();
		return CountryService.getCountry(code);
	}

}
