package org.mohit.java.service;

import org.mohit.java.model.Circle;
import org.mohit.java.model.Traingle;

public class AOP_Proxy_FactoryService {

	public Object getBean(String beanType)
	{
		//if(beanType.equals("shapeService")) return new ShapeService();
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Traingle();
		return null;
	}
	
}
