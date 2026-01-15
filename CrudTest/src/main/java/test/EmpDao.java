package test;

import java.sql.*;
import java.util.*;

public class EmpDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crudtestdb",
                "root",
                "Dhiraj@0933"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO usertable (id, name, password, email, country) VALUES (?, ?, ?, ?, ?)"
            );

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getPassword());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getCountry());

            status = ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }
}
