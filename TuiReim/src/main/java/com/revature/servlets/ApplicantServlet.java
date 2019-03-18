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
import com.revature.dao.UserDaoImpl;


public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In appServlet doGet");
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In appServlet doPost");

		try {

			System.out.println("The try is happening");

			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String uname = req.getParameter("uname");
			String pword = req.getParameter("pword");
			String email = req.getParameter("emaila");
			String etype = req.getParameter("etype");
			String edate = req.getParameter("edate");
			String descr = req.getParameter("descr");
			String locat = req.getParameter("locat");
			double amount = Double.parseDouble(req.getParameter("amount"));
			double finAmount = calculateEventRestrictions(amount, etype);


			User u = new User(fname, lname, uname, pword, email);

			UserDaoImpl udi = new UserDaoImpl();
			udi.createUser(u);
			System.out.println("after"+u.toString());
			int eid = udi.getEmployeeID(uname, pword);
			
			User use = udi.employeeLogin(uname, pword);
			
			System.out.println("This is the damn employee ID: "+eid);
			
			Applicant a = new Applicant(fname, lname, locat, descr, finAmount, etype, edate, eid);//creating applicant object
			ApplicantDaoImpl adi = new ApplicantDaoImpl();//creating object	
			adi.createApplication(a);//this is inserting into table
			
			HttpSession session = req.getSession(true);
			session.setAttribute("user", use);
			session.setAttribute("eidNum", eid);		
			
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");  
			pw.println("<script type=\"text/javascript\">");  
			pw.println("alert('Form has been submitted!');");  
			pw.println("</script>");
			resp.sendRedirect("home.html");
			pw.close();
		} catch (SQLException e) {
			PrintWriter pw = resp.getWriter();
			pw.print("System is down! Please try again later!");
			req.getRequestDispatcher("/WEB-INF/home.html").include(req, resp);
			pw.close();
		}
	}
	
	private static double calculateEventRestrictions(double amt, String str) {
		double calculation = 0f;
		switch (str) {
		case "University_Courses":
			if((amt * .80)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = (amt * .80);
			}
			break;
		case "Seminars":
			if((amt * .60)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = (amt * .60);
			}
			break;
		case "Certification_Preparation_Classes":
			if((amt * .75)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = (amt * .75);
			}
			break;
		case "Certification":
			if((amt)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = amt;
			}
			break;
		case "Technical_Training":
			if((amt * .90)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = (amt * .90);
			}
			break;
		case "Others":
			if((amt * .30)>1000){
				calculation = 1000.00;
			}
			else{
				calculation = amt * .30;
			}
			break;
		default:
			System.out.println("Calculation Error in js");
		}
		
		
		return calculation;
	}

}