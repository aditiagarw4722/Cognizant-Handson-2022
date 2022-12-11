package com.cognizant.employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	
	@Test
	public void testUpdateEmployeeException() throws Exception {
	    ResultActions actions = mvc.perform(put("/employees/0"));
		actions.andExpect(status().isBadRequest());
//        actions.andExpect(status().reason("Employee Not found"));

	}

}
