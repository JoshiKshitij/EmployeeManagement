package org.rest.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_name")
public class AnimalDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "animal_type")
	private String type;
	
	@Column(name = "animal_name")
	private String name;
	
	@Column(name = "animal_age")
	private int age;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "AnimalDto [type=" + type + ", name=" + name + ", age=" + age + "]";
	}
	public AnimalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnimalDto(String type, String name, int age) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
