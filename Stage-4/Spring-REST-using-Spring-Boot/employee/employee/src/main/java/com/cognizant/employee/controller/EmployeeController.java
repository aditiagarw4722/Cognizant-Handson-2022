package com.cognizant.employee.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.exception.EmployeeNotFoundException;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody @Valid Employee employee,@PathVariable("id") int id) throws EmployeeNotFoundException{
		service.updateEmployee(employee,id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException{
		service.deleteEmployee(id);
	}
}
