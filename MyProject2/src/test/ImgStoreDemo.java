package test;

import java.io.File;
import java.io.FileInputStream;


public class ImgStoreDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // Step 1: Register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "Dhiraj@0933"
            );

            // Step 3 : Create Statement
            java.sql.PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO imgtable (name, profile_pic) VALUES (?, ?)"
            );

            // Set name
            pst.setString(1, "David");

            // Set image
            FileInputStream input = new FileInputStream(
                    new File("C:\\Users\\91742\\Desktop\\github_projects\\Advance-Java\\images\\d photo.jpeg")
            );
            pst.setBinaryStream(2, input);
            //Step 4 : Execute Query
            int i = pst.executeUpdate();  // execute update
            if(i > 0)
            {
            	System.out.println(" Data Inserted Successfully");
            }

            // Step5 : Close connection
            input.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
