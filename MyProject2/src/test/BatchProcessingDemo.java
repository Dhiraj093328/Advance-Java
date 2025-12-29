package test;

import java.sql.Statement;

public class BatchProcessingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "Dhiraj@0933"
            );
            
            con.setAutoCommit(false);

            // Create PreparedStatement using fully-qualified name
            Statement stmt = con.createStatement();

           stmt.addBatch("insert into person (id,name,age) values (1,'Ram',24)");
           
           stmt.addBatch("insert into person (id,name,age) values (6,'jhon',43)");
           
           stmt.executeBatch();   // REQUIRED


            // Close connection
           con.commit();
           
           System.out.println("Success");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
