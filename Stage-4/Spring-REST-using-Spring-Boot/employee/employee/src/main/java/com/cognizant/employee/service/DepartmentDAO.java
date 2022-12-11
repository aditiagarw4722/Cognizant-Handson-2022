package com.cognizant.employee.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;

@Component
public class DepartmentDAO {

static ArrayList<Department> DEPARTMENT_LIST = new ArrayList<>();
	
	public DepartmentDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		ArrayList<Department> departments = context.getBean("departmentList", ArrayList.class);
		this.DEPARTMENT_LIST = departments;
	}
	
	public ArrayList<Department> getAllDepartment(){
		return this.DEPARTMENT_LIST;
	}
}
