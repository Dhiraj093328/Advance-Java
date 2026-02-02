package test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

    public static void main(String[] args) {

        // Step 1: Create Configuration
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Hibernate Session
        Session session = factory.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Java is a programming language");
        l1.add("Java is a platform");

        Question q1 = new Question();
        q1.setQname("What is Java?");
        q1.setAnswers(l1);

        session.persist(q1);

        // Step 5: Commit Transaction
        tx.commit();

        // Step 6: Close resources
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
