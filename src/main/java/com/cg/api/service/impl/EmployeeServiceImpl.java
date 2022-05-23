package com.cg.api.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.api.pojo.Employee;
import com.cg.api.repository.AddressRepository;
import com.cg.api.repository.EmployeeRepository;
import com.cg.api.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements Serializable,EmployeeService{

	/**
	 * serialVersionUID = 118132574227962057L;
	 */
	private static final long serialVersionUID = 118132574227962057L;

	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	@Override
	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		addressRepository.save(e.getAddress());
		return employeeRepository.save(e);
	}
	
	@Override
	public List<Employee>findAllEmployee(){
		
		return employeeRepository.findAll();
	}
	
	
}
