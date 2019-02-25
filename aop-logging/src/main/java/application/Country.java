package application;

import org.springframework.stereotype.Component;

public class Country {

	private String name;
	private int noOfStates;

	public Country(String name, int noOfStates) {
		super();
		this.name = name;
		this.noOfStates = noOfStates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStates() {
		return noOfStates;
	}

	public void setNoOfStates(int noOfStates) {
		this.noOfStates = noOfStates;
	}

	@Override
	public String toString() {
		return "Countries [name=" + name + ", noOfStates=" + noOfStates + "]";
	}

}
