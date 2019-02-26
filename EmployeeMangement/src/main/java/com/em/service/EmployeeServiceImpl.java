package com.em.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.em.dto.Employee;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeServiceInterface{

	public Long saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
