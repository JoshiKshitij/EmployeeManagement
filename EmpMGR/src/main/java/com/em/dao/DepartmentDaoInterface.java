package com.em.dao;

import java.io.Serializable;

import com.em.dto.DepartmentDto;

public interface DepartmentDaoInterface {
	
	public Serializable saveDeptInDb(DepartmentDto dept);
}
