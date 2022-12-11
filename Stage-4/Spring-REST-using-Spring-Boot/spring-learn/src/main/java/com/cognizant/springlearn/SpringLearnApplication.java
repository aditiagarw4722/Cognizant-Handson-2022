package com.cognizant.springlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    private static CountryService countryService;
    
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

	
    private static void getAllCountriesTest() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");  
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }
    
    private static void testAddCountry() throws CountryNotFoundException {
       LOGGER.info("Start");
       Country c = new Country();
       c.setCode("gg");
       c.setName("testing");
       countryService.addCountry(c);
       Country r = countryService.findCountryByCode("gg");
       LOGGER.debug("Country:{}", r);
       LOGGER.info("End");
   }
    private static void testUpdate() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.updateCountry("IN","INDIA") ;
        Country r = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", r);
        LOGGER.info("End");
    }
    private static void testDelete() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.deleteCountry("gg") ;
        Country r = countryService.findCountryByCode("gg");
        LOGGER.debug("Country:{}", r);
        LOGGER.info("End");
    }
    



	public static void main(String[] args) throws CountryNotFoundException {
		//SpringApplication.run(SpringLearnApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testGetAllCountries();
        getAllCountriesTest();
        testAddCountry();
        testUpdate();
        testDelete();
	}

}
