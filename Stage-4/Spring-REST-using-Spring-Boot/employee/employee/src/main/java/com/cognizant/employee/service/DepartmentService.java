package com.cognizant.employee.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.employee.model.Department;

@Service
public class DepartmentService {

	Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	DepartmentDAO dao;
	
	@Transactional
	public ArrayList<Department> getAllDepartment(){
		logger.info("Department Service Called");
		return dao.getAllDepartment();
	}
}
