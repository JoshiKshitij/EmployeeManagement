package com.em.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.em.dto.EmployeeDto;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeServiceInterface{

	public Long saveEmployee(EmployeeDto employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteEmployee(EmployeeDto employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public EmployeeDto getEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDto updateEmployee(EmployeeDto employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
