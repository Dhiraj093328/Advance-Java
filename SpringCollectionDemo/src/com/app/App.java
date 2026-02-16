package com.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Question;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		
		Question q=(Question) context.getBean("q1");
		
		q.display();
		

	}

}
