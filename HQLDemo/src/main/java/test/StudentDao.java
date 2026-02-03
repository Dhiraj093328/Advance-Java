package test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDao {

    public static void main(String[] args) {

        // Step 1: Create Configuration
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml"); // Make sure this file is in src/main/resources

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Retrieve all data
        List<Student> l1 = session.createQuery("from Student", Student.class).list();

        // Step 5: Iterate and print
        for (Student s1 : l1) {
            System.out.println(s1.getName() + " " + s1.getAge());
        }

        // Step 6: Close resources
        session.close();
        factory.close();

        System.out.println("Details Retrieved Successfully");
    }
}
