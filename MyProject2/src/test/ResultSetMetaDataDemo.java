package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {

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

            // Create query
            PreparedStatement pst = con.prepareStatement("select * from person");

            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            
            System.out.println("Total no of column : "+rsmd.getColumnCount());
            
            System.out.println("Name of First column : "+rsmd.getColumnName(1));
            
            System.out.println("Type of first column : "+rsmd.getColumnTypeName(1));



           
           
            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
