package com.em.dao;

import java.io.Serializable;

import com.em.dto.EmployeeDto;

public interface EmployeeDaoInterface {
	public EmployeeDto getEmpByLoginId(String loginId );

	public void deleteAccount(EmployeeDto emp);

	public void updateEmp(EmployeeDto empFromJspp);

	public Serializable saveEmpInDb(EmployeeDto employee);
}
