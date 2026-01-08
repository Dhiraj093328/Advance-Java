package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseMetaData {

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "Dhiraj@0933"
            );

            // Get DatabaseMetaData
            java.sql.DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("Driver Name : " + dbmd.getDriverName());
            System.out.println("Driver Version : " + dbmd.getDriverVersion());
            System.out.println("Database Version : " + dbmd.getDatabaseProductVersion());
            System.out.println("Database Name : " + dbmd.getDatabaseProductName());

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
