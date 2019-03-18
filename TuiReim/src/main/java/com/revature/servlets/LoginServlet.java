package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet of LoginServlet");
		RequestDispatcher rd= request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of LoginServlet");
		
		
		
		try {

			UserDaoImpl udi = new UserDaoImpl();
			//0
			String username = request.getParameter("username");

			
			User use = udi.employeeLogin(request.getParameter("username"), request.getParameter("password"));
			String name = udi.getEmployeeName(request.getParameter("username"), request.getParameter("password"));
			
			System.out.println(request.getParameter("username"));
			//1

			System.out.println(use+"\nCheck if this is null");

			// employee
//			if (use.getUserType() > 0 && use.getUserType() < 2) {
//				
//				HttpSession session = request.getSession(true);
//				session.setAttribute("user", use);
//				session.setAttribute("eidNum", use.getEidNumber());
//				response.sendRedirect("home.html");	
//			}
//			else
//				if(use.getUserType() > 1 && use.getUserType() < 3) {
//					HttpSession session = request.getSession(true);
//					session.setAttribute("user", use);
//					session.setAttribute("eidNum", use.getEidNumber());
//					response.sendRedirect("manager.html");	
//					
//				}
//			// Lets the user know the username and password don't match any employee records
//			else {
//				PrintWriter pw = response.getWriter();
//				response.setContentType("text/html");
//				pw.println("<script type=\"text/javascript\">");
//				pw.println("alert(\"Can't find User Name or Pass Word!\");");
//				pw.println("</script>");
//				request.getRequestDispatcher("login.html").include(request, response);
//				pw.close();
//			}
			if(use.getUserType() == 1) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", use);
				session.setAttribute("eidNum", use.getEidNumber());
				response.sendRedirect("manager.html");	
			}else if(use.getUserType() == 2) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", use);
				session.setAttribute("eidNum", use.getEidNumber());
				response.sendRedirect("DepartmentHead.html");	
			}else if(use.getUserType() == 3) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", use);
				session.setAttribute("eidNum", use.getEidNumber());
				response.sendRedirect("Benco.html");	
			}else if(use.getUserType() == 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", use);
				session.setAttribute("eidNum", use.getEidNumber());
				response.sendRedirect("home.html");
			}else {
				PrintWriter pw = response.getWriter();
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert(\"Can't find User Name or Pass Word!\");");
				pw.println("</script>");
				request.getRequestDispatcher("login.html").include(request, response);
				pw.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		
		
		
		
		
		
		
		
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDaoImpl udi = new UserDaoImpl();
		try {
			int eid = udi.getEmployeeID(username, password);
			if(eid>0) {
				System.out.println("Log in Successful");
				request.getRequestDispatcher("home.html").forward(request, response);
			}else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.write("<h3>Login Unsuccessful! Try Again.</h3>");
				pw.close();
				}
			request.getRequestDispatcher("login.html").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//response.sendRedirect("home");
		
	}
	}
}