package com.em.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.em.dto.EmployeeDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoInterface{
		
	@Autowired
	SessionFactory factory;
	
	public EmployeeDto getEmpByLoginId(String loginId ){
		
		Session session = factory.openSession();
		Query query = session.createQuery("select emp from EmployeeDto emp where loginId = : loginId");
		query.setString("loginId", loginId);
		return (EmployeeDto)query.uniqueResult();
	}
	
	
}
