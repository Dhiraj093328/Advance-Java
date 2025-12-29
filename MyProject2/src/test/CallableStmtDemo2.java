package test;

import java.sql.CallableStatement;
import java.sql.Types;

public class CallableStmtDemo2 {

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
		            
		            CallableStatement stmt=con.prepareCall("{call delete_from_person(?,?)}");
		            		stmt.setInt(1 ,5);
		            		stmt.registerOutParameter(2, Types.DOUBLE);
		            		
		            		stmt.execute();

		            System.out.println("sq_of_no"+stmt.getDouble(2));

		            // Close connection
		            con.close();

		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		}
