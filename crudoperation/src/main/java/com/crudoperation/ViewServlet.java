package com.crudoperation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       
       List<Employee>list=null;
      
       out.print("<h1> Employee Table:</h1>");
       out.print("<table border='1' cellpading='4' width='50%'>");
	   out.print("<tr><th>Id</th><th>Employee Name</th><th>Salary</th></tr>");
	   try {
		   list=EmployeeDAO.getAllUsers();
	   }
	   catch(Exception e)
	   {
		 e.printStackTrace();  
	   }
	   
	   if(list!=null)
	   {
		   for(Employee e:list) {
			   out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td></tr>");
		   }
		   out.print("<table>");
	   }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
