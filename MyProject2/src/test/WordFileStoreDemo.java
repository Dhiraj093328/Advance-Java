package test;

import java.io.FileInputStream;

public class WordFileStoreDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "Dhiraj@0933");

            // Step 3: Create query
            java.sql.PreparedStatement pst = con.prepareStatement("INSERT INTO word_files(file_data) VALUES (?)");

            FileInputStream fis = new FileInputStream("C:/Users/91742/Desktop/github_projects/Advance-Java/files/Dk.docx");

            pst.setBinaryStream(1, fis);

            // Step 4: Execute update
            int i = pst.executeUpdate();
            if (i > 0) {
                System.out.println("Word file stored successfully!");
            }

            // Step 5: Close connection
            fis.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
