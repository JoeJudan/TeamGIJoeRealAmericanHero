package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Applicant;
import com.revature.beans.User;
import com.revature.dao.ApplicantDaoImpl;
import com.revature.dao.UserDaoImpl;

/**
 * Servlet implementation class HomeServlet
 */

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet of HomeServlet");
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		String userName = user.getUserName();
		ObjectMapper mapper1 = new ObjectMapper();
		String jsonString1 = mapper1.writeValueAsString(userName);
		
		System.out.println("Is this being called "+userName);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.print(jsonString1);

		pw.close();

		
		
		//request.getRequestDispatcher("home.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of HomeServlet");
	
		String uname = request.getParameter("username");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("This is uname "+uname);
/*		String someName = (String)request.getAttribute("attributeName");
		
		
		response.setContentType("text/html");
		PrintWriter pw2 = response.getWriter();
		pw2.write("<h3>"+someName+"</h3>");
		pw2.close();*/
		
		try {
			UserDaoImpl use = new UserDaoImpl();
			//2
			//HttpSession session = request.getSession(); 
			//3

			int eid = use.getEmployeeId(uname);
			Applicant appli= createDummy(eid);
			
			String jsonString = mapper.writeValueAsString(appli);
			//4

			//System.out.println(jsonString);
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonString);

			pw.close();

		} catch (JsonProcessingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
private static Applicant createDummy(int eid) {
		
	
		
		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		try {
			
			List<Applicant> a = adi.getApplicantList(eid);
			for(Applicant x: a) {
				return x;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
		
	}

}