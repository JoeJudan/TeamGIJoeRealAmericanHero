package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Applicant;
import com.revature.beans.User;
import com.revature.dao.ApplicantDaoImpl;

public class DhUpdateRequestsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3463914249762071737L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("DhUpdateRequests.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		User dh = (User) session.getAttribute("user");
		System.out.println("current User: " + dh.getUserName()); 
		//user dao
		//UserDaoImpl udao = new  UserDaoImpl();
		//applicant dao
		
		ApplicantDaoImpl ado = new ApplicantDaoImpl();
		
		try {
			HttpSession session1 = request.getSession(true);
			//set where you want to go
			String destination = "DepartmentHead.html"; 
			String success = "DhSuccess.html";
			session1.setAttribute("destination", destination);
			session1.setAttribute("success", success);
			
			String operation = request.getParameter("operation"); 
			System.out.println(operation);
			
			int applId = Integer.parseInt(request.getParameter("applId"));
			
			//save applicant id for reason servlet
			session1.setAttribute("applId", applId);
			
			System.out.println("" + applId);
			Applicant appl = ado.getSingleApplicant(applId);
			
			if(operation.equals("APPROVED") && appl.getApprovallevel() == 1 && appl != null) {
				System.out.println("Approved reached");
				ado.updatePendingbydh(applId);
				//ado.updatePending(applId);
				response.sendRedirect("success");
			}else if(operation.equals("DENIED") && appl.getApprovallevel() == 1 && appl != null){
				System.out.println("Denied reached");
				ado.denyRequest(applId);
				response.sendRedirect("denied");
			}else {
				System.out.println("this is a error");
				response.sendRedirect("error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
