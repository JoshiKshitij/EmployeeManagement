package com.em.service;

import com.em.dto.EmployeeDto;

public interface EmployeeServiceInterface {
	
	public Long saveEmployee(EmployeeDto employee);
	public int deleteEmployee(EmployeeDto employee);
	public EmployeeDto getEmployee(Long id);
	public EmployeeDto updateEmployee(EmployeeDto employee);
	
}
