package com.em.dto;

import java.time.LocalDate;
import java.util.Date;


public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private String firstName;
	private String lastName;
	private Date dob;
	private Date dateOfJoing;
	private boolean isActive;

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(Date dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}


	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", dateOfJoing=" + dateOfJoing + ", isActive=" + isActive + "]";
	}

	public Employee(Long id, String firstName, String lastName, Date dob, Date dateOfJoing,
			boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}

	public Employee(String firstName, String lastName,Date dob, Date dateOfJoing, boolean isActive) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}
}
