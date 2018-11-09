package org.mohit.java.service;

import org.mohit.java.aspect.Loggable;
import org.mohit.java.model.Circle;
import org.mohit.java.model.Traingle;

public class ShapeService {

	private Circle circle;
	private Traingle triangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle getter Called fro AOP proxy");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Traingle getTriangle() {
		return triangle;
	}
	public void setTriangle(Traingle triangle) {
		this.triangle = triangle;
	}
	
	
}
