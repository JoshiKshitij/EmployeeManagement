package com.em.service;

import java.io.Serializable;

import com.em.dto.DepartmentDto;

public interface DepartmentServiceInterface {
	
	public Serializable saveDeptInDb(DepartmentDto dept);
	
}
