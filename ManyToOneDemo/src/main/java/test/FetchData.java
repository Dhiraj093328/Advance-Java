package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;

public class FetchData {

    public static void main(String[] args) {

        // Step 1: Create Configuration object
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Create Query
        TypedQuery<Employee> q1 = session.createQuery(
                "from Employee e", Employee.class);

        List<Employee> l1 = q1.getResultList();

        Iterator<Employee> itr = l1.iterator();

        while (itr.hasNext()) {
            Employee emp = itr.next();

            System.out.println(
                    emp.getEmpid() + " " +
                    emp.getName() + " " +
                    emp.getEmail()
            );

            Address add = emp.getAddress();

            System.out.println(
                    add.getAddressline1() + " " +
                    add.getCity() + " " +
                    add.getState() + " " +
                    add.getCountry() + " " +
                    add.getPincode()
            );
        }

        // Step 5: Close resources
        session.close();
        factory.close();

        System.out.println("Details Retrieved Successfully");
    }
}
