package com.em.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.dao.EmployeeDaoImpl;
import com.em.dao.EmployeeDaoInterface;
import com.em.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	EmployeeDaoInterface daoImpl;

	public EmployeeDto getEmpByLoginId(String loginId) {
		return daoImpl.getEmpByLoginId(loginId);
	}

	public void deleteAccount(EmployeeDto emp) {
		daoImpl.deleteAccount(emp);	
	}

	public void udpateEmp(EmployeeDto empFromJspp) {
		daoImpl.updateEmp(empFromJspp);
		
	}

}
