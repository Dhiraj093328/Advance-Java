package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	   public static List<Emp> getRecords(int start,int pagelimit){
			
			List<Emp> list=new ArrayList<Emp>();
			
			try {
				Connection con=EmpDao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from usertable limit "+(start-1)+","+pagelimit);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Emp e=new Emp();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setPassword(rs.getString(3));
					e.setEmail(rs.getString(4));
					e.setCountry(rs.getString(5));
					
					list.add(e);
				}
				con.close();
				
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			return list;
		}}
