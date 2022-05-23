package com.cg.api.service;

import java.util.List;

import com.cg.api.pojo.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee e);

	List<Employee> findAllEmployee();
	
}
