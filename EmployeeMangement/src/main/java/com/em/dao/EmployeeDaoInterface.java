package com.em.dao;

import com.em.dto.EmployeeDto;

public interface EmployeeDaoInterface {
	public EmployeeDto getEmpByLoginId(String loginId );

	public void deleteAccount(EmployeeDto emp);

	public void updateEmp(EmployeeDto empFromJspp);
}
