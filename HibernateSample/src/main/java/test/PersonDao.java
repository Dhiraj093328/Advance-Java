package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonDao {

    public static void main(String[] args) {

        // Load Hibernate configuration
        Configuration conf = new Configuration();
        conf.configure("Person.hibernate.cfg.xml"); // make sure file is in classpath

        // Build session factory
        SessionFactory factory = conf.buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Create and save a Person object
        Person p = new Person("Ram", 21, "Pune", 51000);
        session.save(p);

        // Commit transaction
        tx.commit();

        // Close resources
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
