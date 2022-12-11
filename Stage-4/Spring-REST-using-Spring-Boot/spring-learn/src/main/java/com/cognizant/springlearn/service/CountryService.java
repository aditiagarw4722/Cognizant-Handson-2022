package com.cognizant.springlearn.service;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.*;;

@Service 
public class CountryService {
	
	@Autowired
	CountryRepository repo;
	
	@Transactional
	public List<Country> getAllCountries() {
		return repo.findAll();
		
  }
	 @Transactional
	 public Country findCountryByCode(String countryCode) throws CountryNotFoundException
	 {
		 Optional<Country> result = repo.findById(countryCode);
		 Country c = new Country();
		 if (result.isPresent())
			 c = result.get();
		 return c;
		
	 }
	 
	 @Transactional
	 public void addCountry(Country country) {
	 repo.save(country);
	 }

	 @Transactional
	 public void updateCountry(String x, String y) {
		 Country c = new Country();
		 c.setCode(x);
		 c.setName(y);
		 repo.save(c);	 
	 }
	 
	 @Transactional
	 public void deleteCountry(String code) {
		 repo.deleteById(code);
		 
	 }
	

	

}

