package test;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.ResultSet;

public class TextReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Step 1: Register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Dhiraj@0933");

            // Step 3 : Create Query
            java.sql.PreparedStatement pst =con.prepareStatement("select * from texttable");

            // Step 4 : Execute Query
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Blob b = rs.getBlob(2);
                byte barr[] = b.getBytes(1, (int) b.length());

                FileOutputStream out =new FileOutputStream("C:\\Users\\91742\\Desktop\\github_projects\\Advance-Java\\files\\ft.txt");

                out.write(barr);
                out.close();

                System.out.println("Text File Retrive Successfully");
            }

            // Step 5 : Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }


	}

}
