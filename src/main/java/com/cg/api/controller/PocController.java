package com.cg.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.api.dto.EmployeeDto;
import com.cg.api.exception.handling.ResourceNotFoundException;
import com.cg.api.exception.handling.ResourceNotSavedException;
import com.cg.api.pojo.Address;
import com.cg.api.pojo.Employee;
import com.cg.api.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PocController {

	 Logger logger = LoggerFactory.getLogger(PocController.class);
	
	 @Autowired
	 private EmployeeService employeeService;
	 
	 
	@GetMapping("/")
	public String ping() {
		 logger.info("Process started");
		return "working";
	}

	@PostMapping("/saveEmployee")
	public ResponseEntity<?>saveEmployee(@RequestBody EmployeeDto e) throws ResourceNotSavedException{
		try{
			
		Employee em=new Employee();
		Address ad=new Address();
		em.setAddress(ad);
		BeanUtils.copyProperties(e,em);
		BeanUtils.copyProperties(e,ad);
		em.setEmpId(e.getEmpId());
		ad.setAddressId(e.getAddressId());
		
		em=employeeService.saveEmployee(em);
		if(em.getEmpId()!=null) {
			e.setEmpId(em.getEmpId());
			e.setAddressId(em.getAddress().getAddressId());
		}
		
		}catch(Exception ex) {
			throw new ResourceNotSavedException();
		}
		
		
		return new ResponseEntity<EmployeeDto>(e,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?>employees() throws ResourceNotFoundException{
		List<Employee>emps=null;
		List<EmployeeDto>empDtos=new ArrayList<EmployeeDto>();
		try{
			
			emps=employeeService.findAllEmployee();
		for(Employee e:emps) {
			EmployeeDto eDto=new EmployeeDto();
			BeanUtils.copyProperties(e,eDto);
			BeanUtils.copyProperties(e.getAddress(),eDto);
			empDtos.add(eDto);
		}
			
			
		}catch(Exception ex) {
			throw new ResourceNotFoundException();
		}
		
		return new ResponseEntity<List<EmployeeDto>>(empDtos,HttpStatus.OK);
	}

	
	
}
