package app.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tabel_student")
public class StudentDto {
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc" , strategy = "increment")
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column (name = "stream")
	private String stream;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "pincode" , column =@Column(name = "office_pincode")),
		@AttributeOverride(name = "street" , column =@Column(name = "office_street")),
	})
	private Address officeAddress;
	

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentDto(String name) {
		super();
		this.name = name;
	}

	public StudentDto(String name, String stream) {
		super();
		this.name = name;
		this.stream = stream;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
