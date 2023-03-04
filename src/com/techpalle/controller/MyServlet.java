package com.techpalle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Student;


@WebServlet("/")
public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String path=request.getServletPath();
		switch(path)
		{
		
		case "/updatedetails":
			getUpdatePage(request , response);
			break;
		case "/deletedetails":
			getdeletePage(request , response);
			break;
		case "/update":
			updateStudent(request,response);
			break;
		case "/delete":
			deleteStudent(request,response);
			break;
		case "/showall":
			showAllStudent(request,response);
			break;
		default:
			 getAllData(request,response);
				break;
		}
	}


	private void showAllStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body style=background-color:pink; color:black><div align= 'center'>");
			out.println("<title> Students Details </title>");
			out.println("<h1> STUDENTS TABLE</h1>");
			out.println("<table border='1'><th>Name</th><th>Email</th><th>Password</th><th>States</th>");
			ArrayList<Student> stud=DataAccess.reading();
			for(Student item : stud)
			{
				
				out.println("<tr><td>"+item.getName()+"</td><td>"+item.getEmail()+"</td><td>"+item.getPassword()+"</td><td>"+item.getStates()+"</td>");

			}
			out.println("</table></body></html></div>");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getdeletePage(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("tbEmail");
		
		DataAccess.deleteStudent(email);
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getUpdatePage(HttpServletRequest request, HttpServletResponse response)
	{
		String email=request.getParameter("tbEmail");
		String name=request.getParameter("tbName");
		String password=request.getParameter("tbPassword");
		String states=request.getParameter("ddlStates");
		//long mobile=Long.parseLong(request.getParameter("tbMobile"));
		
		Student s=new Student(name, email,password, states);
		DataAccess.updateStudent(name, password, states, email);
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getAllData(HttpServletRequest request, HttpServletResponse response) 
	{
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		String password=request.getParameter("tbPassword");
		String states=request.getParameter("ddlStates");
		//long mobile=Long.parseLong(request.getParameter("tbMobile"));
		
		Student s=new Student(name, email,password, states);
		DataAccess.insertStudent(s);
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
	}

}
