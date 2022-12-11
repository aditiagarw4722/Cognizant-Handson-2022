package com.cognizant.springlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public class CountryService {
	
	
	private static ApplicationContext context;

	public static  Optional<Country> getCountry(String code) throws CountryNotFoundException  {
		context = new ClassPathXmlApplicationContext("country.xml"); 
		List<Country> country = (List<Country>) context.getBean("countryList", List.class);
		
		for(Country c : country)	{
			if(code.equalsIgnoreCase(c.getCode())) {
				return Optional.ofNullable(c);
			}	
		}
		try {
	    throw new CountryNotFoundException("Country not found");
		}
		finally{
			
		}
		
		
		
	}

}

