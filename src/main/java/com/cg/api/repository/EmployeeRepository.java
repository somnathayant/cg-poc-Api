package com.cg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.api.pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
