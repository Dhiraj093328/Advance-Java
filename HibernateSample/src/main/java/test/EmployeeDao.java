package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {

    public static void main(String[] args) {

        // Step 1: Read details from hibernate configuration file
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Create Employee object
        Employee emp = new Employee("vikas", 51000);

        // Save object
        session.save(emp);

        // Commit transaction
        tx.commit();

        // Close resources
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
