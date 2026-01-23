package test;

import java.sql.*;
import java.util.*;

public class EmpDao {

    // 🔹 DB CONNECTION
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/u_records",
                "root",
                "Dhiraj@0933"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // 🔹 LOGIN VALIDATION
    public static boolean validate(String username, String password) {
        boolean status = false;

        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usertable WHERE name=? AND password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next(); // true = valid login

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    // 🔹 GET ALL USERS (for table display if needed)
    public static List<User> getAllUsers() {

        List<User> list = new ArrayList<User>();

        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT id, name, email, country FROM usertable"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setCountry(rs.getString(4));

                list.add(u);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
