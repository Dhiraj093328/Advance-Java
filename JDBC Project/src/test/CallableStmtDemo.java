package test;

import java.sql.CallableStatement;

public class CallableStmtDemo {

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
		            
		            CallableStatement stmt=con.prepareCall("{call delete_from_person(?)}");
		            		stmt.setInt(1 ,1);
		            		
		            		stmt.execute();

		            System.out.println("Deletion successfully");

		            // Close connection
		            con.close();

		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		}
