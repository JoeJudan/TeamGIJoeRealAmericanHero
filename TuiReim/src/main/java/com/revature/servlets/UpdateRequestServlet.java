package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Applicant;
import com.revature.beans.User;
import com.revature.dao.ApplicantDaoImpl;
import com.revature.dao.UserDaoImpl;

public class UpdateRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211595188849235029L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("UpdateRequest.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		User admin = (User) session.getAttribute("user");
		System.out.println("current User: " + admin.getUserName()); 
		//user dao
		//UserDaoImpl udao = new  UserDaoImpl();
		//applicant dao
		
		ApplicantDaoImpl ado = new ApplicantDaoImpl();
		
		try {
			HttpSession session1 = request.getSession(true);
			//set where you want to go
			String destination = "manager.html"; 
			String success = "Success.html";
			session1.setAttribute("destination", destination);
			session1.setAttribute("success", success);
			
			String operation = request.getParameter("operation"); 
			System.out.println(operation);
			int applId = Integer.parseInt(request.getParameter("applId"));
			
			//save applicant id for reason servlet
			session1.setAttribute("applId", applId);
			
			System.out.println("" + applId);
			Applicant appl = ado.getSingleApplicant(applId);
			
			if(operation.equals("APPROVED") && appl.getApprovallevel() == 0 && appl != null) {
				System.out.println("Approved reached");
				ado.updatePending(applId);
				response.sendRedirect("success");
			}else if(operation.equals("DENIED") && appl.getApprovallevel() == 0 && appl != null){
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
