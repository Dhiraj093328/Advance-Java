package test;

import java.sql.CallableStatement;
import java.sql.Types;

public class CallableStatementFactorial {

	public static void main(String[] args) {

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "Dhiraj@0933"
            );

            // Create PreparedStatement using fully-qualified name
            
            CallableStatement cst=con.prepareCall("{call fact_of_no(?,?)}");
            		cst.setInt(1 ,5);
            		cst.registerOutParameter(2, Types.BIGINT);
            		
            		cst.execute();

            System.out.println("Factorial_of_no : "+cst.getLong(2));

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
