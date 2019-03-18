package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.ApplicantDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class UpdateGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet of UpdateGradeServlet");
		RequestDispatcher rd= request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of UpdateGradeServlet");
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		int eid = user.getEidNumber();
		String grade = request.getParameter("grade");
		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		
		try {
			adi.updateGrade(eid, grade);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String yourStringVAlue = "helloworld";
		//System.out.println("This is being printed "+yourStringVAlue);
		request.setAttribute("attributeName",yourStringVAlue);
		RequestDispatcher rd = request.getRequestDispatcher("home.html");
		rd.forward(request,response);
		//request.getRequestDispatcher("home.html").forward(request, response);
	}

}