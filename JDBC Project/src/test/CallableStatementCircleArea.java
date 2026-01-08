package test;

import java.sql.CallableStatement;
import java.sql.Types;

public class CallableStatementCircleArea {

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

            // Create PreparedStatement using fully-qualified name
            
            CallableStatement stmt=con.prepareCall("{call Area_of_Circle(?,?)}");
            		stmt.setInt(1 ,5);
            		stmt.registerOutParameter(2, Types.DOUBLE);
            		
            		stmt.execute();

            System.out.println("Area_of_Circle : "+stmt.getDouble(2));

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }


	}

}
