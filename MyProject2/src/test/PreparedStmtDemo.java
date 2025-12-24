package test;

public class PreparedStmtDemo {

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
            java.sql.PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO person (id, name, age) VALUES (?, ?, ?)"
            );

            pst.setInt(1, 4);           // id
            pst.setString(2, "David");  // name
            pst.setInt(3, 32);          // age

            int i = pst.executeUpdate();  // execute update
            System.out.println(i + " Record Inserted");

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
