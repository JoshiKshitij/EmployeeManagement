package com.em.service;

import java.io.Serializable;

import com.em.dto.EmployeeDto;

public interface EmployeeServiceInterface {
	
	/*
	 * public Long saveEmployee(EmployeeDto employee); public int
	 * deleteEmployee(EmployeeDto employee); public EmployeeDto getEmployee(Long
	 * id); public EmployeeDto updateEmployee(EmployeeDto employee);
	 */
	public EmployeeDto getEmpByLoginId(String loginId );

	public void deleteAccount(EmployeeDto emp);

	public void udpateEmp(EmployeeDto empFromJspp);

	public Serializable saveEmpInDb(EmployeeDto employee);
	
	
}
