package test;

// Import all classes from java.sql package for JDBC
import java.sql.*;

public class TestClass {

    public static void main(String[] args) {

        // Step 0: Handle exceptions using try-catch
        try {
            // Step 1: Load MySQL JDBC driver
            // This registers the driver with DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            // Format: jdbc:mysql://<host>:<port>/<database_name>
            // Username: root
            // Password: Dhiraj@0933
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "Dhiraj@0933"
            );

            // Step 3: Create a Statement object
            // This object allows executing SQL queries
            Statement stmt = con.createStatement();

            // Step 4: Execute a SQL query and get the results
            // "select * from person" retrieves all records from 'person' table
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            // Step 5: Process the ResultSet
            // rs.next() moves the cursor to the next row, returns false if no more rows
            while (rs.next()) {
                // Get data from each column by index (1-based)
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);

                // Print the record
                System.out.println("Id: " + id + " Name: " + name + " Age: " + age);
            }

            // Step 6: Close the connection
            // Always close connection to free resources
            con.close();

        } catch (Exception e) {
            // Catch any exceptions (like SQLException or ClassNotFoundException)
            // Print the error to understand what went wrong
            System.out.println("Error: " + e);
        }
    }
}
