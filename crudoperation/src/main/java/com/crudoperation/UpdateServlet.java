package com.crudoperation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		int id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float salary=Float.parseFloat(request.getParameter("sal"));
		
		Employee obj=new Employee();
		obj.setId(id);
		obj.setName(name);
		obj.setSalary(salary);
		System.out.println(obj.toString());

		
		int status=EmployeeDAO.updateemployee(obj);
		
		if(status>0)
		{
			out.print("<p>Record Updated Successfully!</p>");
			request.getRequestDispatcher("update.html")
			.include(request, response);
			
		}
		else {
			out.println("Sorry! Unable to update record");
			request.getRequestDispatcher("update.html")
			.include(request, response);
		}
		out.close();
	}

}
