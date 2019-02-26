package com.em.dto;

import java.time.LocalDate;

public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private LocalDate dateOfJoing;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(LocalDate dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", dateOfJoing=" + dateOfJoing + ", isActive=" + isActive + "]";
	}

	public Employee(Long id, String firstName, String lastName, LocalDate dob, LocalDate dateOfJoing,
			boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}

	public Employee(String firstName, String lastName, LocalDate dob, LocalDate dateOfJoing, boolean isActive) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}
}
