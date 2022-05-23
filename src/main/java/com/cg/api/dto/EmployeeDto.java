package com.cg.api.dto;

import java.io.Serializable;

import com.cg.api.pojo.Employee;


public class EmployeeDto implements Serializable{
	
	/**
	 * serialVersionUID = 5467158754612371676L;

	 */
	private static final long serialVersionUID = 5467158754612371676L;

	private Integer empId;
	
	private String name;
	private Integer salary;
	
	private Integer addressId;
	private String state;
	private String city;
	
	private Employee e;
	private String msg;
	//setter and getter
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Employee getE() {
		return e;
	}
	public void setE(Employee e) {
		this.e = e;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	
	
	
}
