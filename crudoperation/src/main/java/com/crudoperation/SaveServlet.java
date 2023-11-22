package com.crudoperation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float salary=Float.parseFloat(request.getParameter("sal"));
		
		Employee obj=new Employee();
		obj.setId(id);
		obj.setName(name);
		obj.setSalary(salary);
		System.out.println(obj.toString());
		int status=EmployeeDAO.save(obj);
		
		if(status>0)
		{
			out.print("<p>Record saved Successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			out.print("Sorry! unable to save record");
	         request.getRequestDispatcher("index.html").include(request, response);
	           
		}
		out.close();
	}

}
