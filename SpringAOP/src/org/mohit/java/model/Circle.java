package org.mohit.java.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("It is called");
		throw(new RuntimeException());
	}
	
	public String setNameReturn(String name) {
		this.name = name;
		System.out.println("It is called");
		return name;
	}
}
