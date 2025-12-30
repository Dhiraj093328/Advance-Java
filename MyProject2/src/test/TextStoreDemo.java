package test;

import java.io.FileInputStream;

public class TextStoreDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Dhiraj@0933");

            // Step 3 : Create Query
            java.sql.PreparedStatement pst = con.prepareStatement("insert into texttable(text_data) values(?)");

            FileInputStream fis = new FileInputStream("C:\\Users\\91742\\Desktop\\github_projects\\Advance-Java\\files\\ft.txt");

            pst.setBinaryStream(1, fis);

            // Step 6 : Execute Query
            int i = pst.executeUpdate();
            if (i > 0) {
                System.out.println("Text File Stored Successfully");
            }
            // Step 7 : Close connection
            fis.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
