package org.rest.dto;


public class AnimalDto {
		
	private String type;
	private String name;
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
	
	
}
