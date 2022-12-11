package com.cognizant.employee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.employee.exception.EmployeeNotFoundException;
import com.cognizant.employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao;
	
	@Transactional
	public ArrayList<Employee> getAllEmployee(){
		return dao.getAllEmployee();
	}
	
	@Transactional
	public void updateEmployee(Employee e, int id) throws EmployeeNotFoundException {
		dao.updateEmployee(e,id);
	}
	
	@Transactional
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		dao.deleteEmployee(id);
	}
}
