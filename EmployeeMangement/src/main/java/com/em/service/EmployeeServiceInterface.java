package com.em.service;

import com.em.dto.Employee;

public interface EmployeeServiceInterface {
	
	public Long saveEmployee(Employee employee);
	public int deleteEmployee(Employee employee);
	public Employee getEmployee(Long id);
	public Employee updateEmployee(Employee employee);
	
}
