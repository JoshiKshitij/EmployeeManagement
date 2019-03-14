package com.em.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.dao.DepartmentDaoInterface;
import com.em.dto.DepartmentDto;

@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface{

	@Autowired
	DepartmentDaoInterface dao;
	
	public Serializable saveDeptInDb(DepartmentDto dept) {
		
		return dao.saveDeptInDb(dept);
	}

}
