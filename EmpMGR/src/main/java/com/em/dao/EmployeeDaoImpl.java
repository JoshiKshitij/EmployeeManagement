package com.em.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.em.dto.CompanyDto;
import com.em.dto.DepartmentDto;
import com.em.dto.EmployeeDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoInterface {

	@Autowired
	SessionFactory factory;

	public EmployeeDto getEmpByLoginId(String loginId) {

		Session session = factory.openSession();
		Query query = session.createQuery("select emp from EmployeeDto emp where loginId = : loginId");
		query.setString("loginId", loginId);
		return (EmployeeDto) query.uniqueResult();
	}

	public void deleteAccount(EmployeeDto emp) {
		Session session = factory.openSession();
		EmployeeDto employeeDto = session.get(EmployeeDto.class, emp.getId());
		session.beginTransaction();
		session.delete(employeeDto);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmp(EmployeeDto empFromJspp) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(empFromJspp);
		session.getTransaction().commit();
		session.close();
	}

	public Serializable saveEmpInDb(EmployeeDto employee) {		
		Serializable id = 0;
		try {
				
				Session session = factory.openSession();
				session.clear();
				Transaction transaction = session.beginTransaction();

				DepartmentDto departmentDto = session.get(DepartmentDto.class, employee.getDepartment().getId());
				CompanyDto companyDto = session.get(CompanyDto.class, employee.getCompany().getId());
				companyDto.getListOfEmps().add(employee);
				departmentDto.getListOfEmps().add(employee);
				
				employee.setCompany(companyDto);
				employee.setDepartment(departmentDto);
				id = session.save(employee);
				transaction.commit();
				session.clear();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
		}
	
}
