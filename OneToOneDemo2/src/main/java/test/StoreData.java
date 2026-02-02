package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

    public static void main(String[] args) {

        // Step 1
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3
        Session session = factory.openSession();

        // Step 4
        Transaction tx = session.beginTransaction();

        // Employee
        Employee e1 = new Employee();
        e1.setName("Nitin Arora");
        e1.setEmail("nitin@example.com");

        Employee e2 = new Employee();
        e2.setName("Amol Patil");
        e2.setEmail("amol@example.com");

        Address a1 = new Address();
        a1.setAddressline1("Hinjewadi Phase III");
        a1.setCity("Pune");
        a1.setState("Maharashtra");
        a1.setCountry("India");
        a1.setPincode(411062);

        e1.setAddress(a1);
        e2.setAddress(a1);

        // Persist objects
        session.persist(e1);
        session.persist(e2);

        // Commit
        tx.commit();

        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
