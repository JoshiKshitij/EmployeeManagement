package app.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	//@Column(name = "student_addr")
	private String pincode;
	
	private String street;

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address(String pincode, String street) {
		super();
		this.pincode = pincode;
		this.street = street;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
