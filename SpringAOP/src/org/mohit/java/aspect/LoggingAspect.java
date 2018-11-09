package org.mohit.java.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("execution(public * get*(..))")
	public void LoggingAdvice()
	{
		System.out.println("Advice Run, Get Method called");
	}
	
	@Before("allGetters() && allCircleMethod()")
	public void SecondAdvice()
	{
		System.out.println("Second Advice Run, Get Method called");
	}
	
	@Pointcut("execution( * get*())")
	public void allGetters()
	{}
	
	@Pointcut("within(org.mohit.java.model.Circle)")
	public void allCircleMethod() {}
	
	
	@Before("allCircleMethod()")
	public void ThirdAdvice(JoinPoint jointPoint)
	{
		System.out.println(jointPoint.toString() + " " + jointPoint.getTarget());
	}
	
	//@Before("args(name)")
	@AfterReturning("args(name)")
	public void stringArgumentMethod(String name)
	{
		System.out.println("A method that takes String args has been called, value is : "+name);
	}
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethodReturn(String name, String  returnString)
	{
		System.out.println("A method that takes String args has been called, value is : "+name + "output is:"+returnString);
	}
	
	@AfterThrowing("args(name)")
	public void stringArgumentMethod_exception(String name)
	{
		System.out.println("A method that takes String args with Exception has been called, value is : "+name);
	}
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingjoinPoint)
	{
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingjoinPoint.proceed();
			System.out.println("After Returning");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	
	
	
	@Around("@annotation(org.mohit.java.aspect.Loggable)")
	public Object myCustomAroundAdvice(ProceedingJoinPoint proceedingjoinPoint)
	{
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingjoinPoint.proceed();
			System.out.println("After Returning");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}

	
	public void logadv()
	{
		System.out.println("Looging from Advice AOP");
	}
	
}
