package com.cognizant.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.employee.exception.EmployeeNotFoundException;
import com.cognizant.employee.model.Employee;

@Component
public class EmployeeDAO {

	static ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<>();
	
	public EmployeeDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		ArrayList<Employee> employees = context.getBean("employeeList", ArrayList.class);
		this.EMPLOYEE_LIST = employees;
	}
	
	public ArrayList<Employee> getAllEmployee(){
		return this.EMPLOYEE_LIST;
	}
	
	public void updateEmployee(@RequestBody @Valid Employee employee, @PathVariable int id) throws EmployeeNotFoundException{
		int c = 0;
		for(Employee e : this.EMPLOYEE_LIST) {
			c++;
			if(e.getId() == id) {
				e.setId(employee.getId());
				e.setName(employee.getName());
				e.setSalary(employee.getSalary());
				e.setPermanent(employee.isPermanent());
				e.setDep(employee.getDep());
				e.setSkills(employee.getSkills());
				break;
			}
		}
		
		if(c==this.EMPLOYEE_LIST.size()) {
			throw new EmployeeNotFoundException();
		}
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		int c = 0;
		for(Employee e : this.EMPLOYEE_LIST) {
			if(e.getId() == id) {
				this.EMPLOYEE_LIST.remove(this.EMPLOYEE_LIST.indexOf(e));
				break;
			}
			c++;
		}
		
		if(c==this.EMPLOYEE_LIST.size()) {
			throw new EmployeeNotFoundException();
		}
	}
}
