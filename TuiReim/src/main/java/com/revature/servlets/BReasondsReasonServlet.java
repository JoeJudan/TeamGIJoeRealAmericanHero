package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ApplicantDaoImpl;

public class BReasondsReasonServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2342126115646632846L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(); 
		String destination = (String) session1.getAttribute("destination");
		request.getRequestDispatcher(destination).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(); 
		int aid = (int) session1.getAttribute("applId");
		String reason = request.getParameter("dscomment");
		System.out.println(reason);
		System.out.println("You reached " + aid);
		//initialize the applicant dao 
		ApplicantDaoImpl ado = new ApplicantDaoImpl(); 
			try {
				if(reason.isEmpty()) {
					reason = "N/A";
					ado.addReason(aid, reason);
					response.sendRedirect("successc");
				}else {
					ado.addReason(aid, reason);
					response.sendRedirect("successc");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}