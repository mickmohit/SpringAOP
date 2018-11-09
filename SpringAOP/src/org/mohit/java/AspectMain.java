package org.mohit.java;

import org.mohit.java.service.AOP_Proxy_FactoryService;
import org.mohit.java.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeservice= ctx.getBean("shapeService",ShapeService.class);
		shapeservice.getCircle().setNameReturn("Dummy");
		System.out.println(shapeservice.getCircle().getName());
		
		
		AOP_Proxy_FactoryService fs =new AOP_Proxy_FactoryService();
		ShapeService ss= (ShapeService) fs.getBean("shapeService");
		ss.getCircle();
	}

}
