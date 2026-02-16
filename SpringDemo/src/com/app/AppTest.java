package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// It will create the dependency Injection
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		System.out.println("Hello Spring");

		System.out.println(context.getBean("employee1"));

	}

}