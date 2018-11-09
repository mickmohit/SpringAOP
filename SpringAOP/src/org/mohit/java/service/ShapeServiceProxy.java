package org.mohit.java.service;

import org.mohit.java.aspect.LoggingAspect;
import org.mohit.java.model.Circle;

public class ShapeServiceProxy  extends ShapeService{

	
	public Circle getCircle() {
		new LoggingAspect().logadv();
		System.out.println("Circle getter Called fro AOP proxy");
		return super.getCircle();
	}
	
}
