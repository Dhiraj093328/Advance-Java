package test;
import java.util.*;
import java.sql.*;

public class EmpDao {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudtestdb","root","Dhiraj@0933");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(Emp e)
	{
		int status=0;
		try {
			
				Connection con=EmpDao.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into usertable(id,name,password,email,country)values (?,?,?,?,?)");
				ps.setInt(1, e.getId());
				ps.setString(1, e.getName());
				ps.setString(2, e.getPassword());
				ps.setString(1, e.getEmail());
				ps.setString(1, e.getCountry());
				
				status=ps.executeUpdate();
						con.close();

		} catch(Exception e1)
		{
			System.out.println(e1);
		}
		return status;
	}

}
