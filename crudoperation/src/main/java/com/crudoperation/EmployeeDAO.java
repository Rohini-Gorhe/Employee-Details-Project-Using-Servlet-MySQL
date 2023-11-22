package com.crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private static String jdbcURL="jdbc:mysql://localhost:3306/servlet";
	private static String jdbcUsername="root";
	private static String jdbcPassword="Nilesh@1488";
   
	public static Connection getConnectionDB()
	{
		Connection con= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		}
		catch(SQLException e) 
		{
			System.out.println("Message..."+e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Message.."+e.getMessage());
			e.printStackTrace();
		}
		return con;
		
	}
	//Rest of the methods like save,
	//Update,Delete etc., should come here
	
	public static int save(Employee e)
	{
		int n=0;
		try {
			Connection con=getConnectionDB();
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, e.id);
			ps.setString(2, e.name);
			ps.setFloat(3, e.salary);
			n=ps.executeUpdate();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return n;
	}
	public static int updateemployee(Employee e)
	{
		int n=0;
		try {
			Connection con=getConnectionDB();
			PreparedStatement ps=con.prepareStatement("update employee set name=?, salary=? where id=?");
			ps.setString(1, e.name);
			ps.setFloat(2, e.salary);
			ps.setInt(3, e.id);
			n=ps.executeUpdate();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return n;
		
	}
	
	public static int deleteemployee(Employee e)
	{
		int n=0;
		try {
			Connection con=getConnectionDB();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, e.getId());
			n=ps.executeUpdate();
			System.out.println(n);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return n;
		
	}
	
	public static List<Employee>getAllUsers()
	{
		List<Employee>list=new ArrayList<Employee>();
		try {
			Connection connect=getConnectionDB();
			
			Statement st;
			
			st=connect.createStatement();
			
			ResultSet rs=st.executeQuery("select * from employee");
			
			while(rs.next()) {
				Employee eobj=new Employee();
				eobj.setId(rs.getInt(1));
				eobj.setName(rs.getString(2));
				eobj.setSalary(rs.getFloat(3));
				
				list.add(eobj);
			}
			connect.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
