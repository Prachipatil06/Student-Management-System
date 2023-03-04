package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class DataAccess
{
	private static final String dbUrl="jdbc:mysql://localhost:3306/exam";
	private static final String dbUsername="root";
	private static final String dbPassword="admin";
	
	private static Connection con=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into student(name,email,password,states) values(?,?,?,?)";
	
	private static final String validateQry="update student set name=?, password=?,states=?  where email=?";
	
	private static final String activeQry="delete from student where email=?";
	
	private static final String selectQury="select * from student";
	
	public static void deleteStudent(String email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			ps=con.prepareStatement(activeQry);
			ps.setString(1, email);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}	
	}


	public static void updateStudent(String name, String password, String states, String email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			ps=con.prepareStatement(validateQry);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, states);
			ps.setString(4, email);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}	
	}
	public static void insertStudent(Student s) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			ps=con.prepareStatement(insertQry);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getPassword());
			ps.setString(4,s.getStates());
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
	}
	public static  ArrayList<Student> reading()
	{
		ArrayList<Student> stud=new ArrayList<Student>();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		stm=con.createStatement();
		rs=stm.executeQuery(selectQury);
		
		while(rs.next())
		{
			String n=rs.getString("name");
			String e=rs.getString("email");
			String p=rs.getString("password");
			String s=rs.getString("states");
			
			Student d= new Student(n, e, p, s);
			stud.add(d);	
		}
	} 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
			if(stm!=null)
			{
				stm.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
		return stud;	
	}
	}
