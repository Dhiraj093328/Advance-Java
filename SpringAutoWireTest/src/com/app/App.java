package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.model.A;

public class App {

    public static void main(String[] args) {
        // Load Spring context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Get bean of A (B will be autowired)
        A a = context.getBean("a", A.class);

        // Call display method
        a.display();
    }
}
