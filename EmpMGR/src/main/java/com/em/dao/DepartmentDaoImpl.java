package com.em.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.em.dto.DepartmentDto;

@Repository
public class DepartmentDaoImpl  implements DepartmentDaoInterface{
	
	@Autowired
	SessionFactory factory;
	
	
	public Serializable saveDeptInDb(DepartmentDto dept) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(dept);
		session.getTransaction().commit();
		session.close();
		return null;
	}

}
