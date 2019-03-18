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

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet of ManagerServlet");
		//request.getRequestDispatcher("home.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of ManagerServlet");
	
		String status = request.getParameter("status");//value for status of the applicant
		//String levelOfApproval = request.getParameter("loa");//value for the approval level
		//this goes to the dao
		//int loa = Integer.parseInt(levelOfApproval);
		
		//System.out.println(levelOfApproval);
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		int type = user.getUserType(); 
		System.out.println("type: " + type);
		
		
		System.out.println("This is what is being assigned: "+status);
		
		ObjectMapper mapper = new ObjectMapper();
		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		
		
		
		try {
			if(status.equals("denied")) {
				List<Applicant> a = adi.getApplicantList(status);
				String jsonString = mapper.writeValueAsString(a);
				
				System.out.println(jsonString);
				
				response.setContentType("application/json");
				PrintWriter pw = response.getWriter();
				pw.print(jsonString);
	
				pw.close();
			}else if(status.equals("approved")) {
				List<Applicant> a = adi.getApplicantList(status);
				String jsonString = mapper.writeValueAsString(a);
				
				System.out.println(jsonString);
				
				response.setContentType("application/json");
				PrintWriter pw = response.getWriter();
				pw.print(jsonString);

				pw.close();
			
			}else if(status.equals("pending")) {
				List<Applicant> a = adi.getApplicantList(status, type-1);
				String jsonString = mapper.writeValueAsString(a);
				System.out.println(jsonString);
				response.setContentType("application/json");
				PrintWriter pw = response.getWriter();
				pw.print(jsonString);

				pw.close();
			}else if(status.isEmpty()) {
				List<Applicant> a = adi.getApplicantList();
				String jsonString = mapper.writeValueAsString(a);
				
				System.out.println(jsonString);
				
				response.setContentType("application/json");
				PrintWriter pw = response.getWriter();
				pw.print(jsonString);

				pw.close();
			}
		
		
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*try {
			//2
			//HttpSession session = request.getSession(); 
			//3

			Applicant appli= createDummy(status);
			
			String jsonString = mapper.writeValueAsString(appli);
			//4

			System.out.println(appli);
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonString);

			pw.close();

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	
/*private static Applicant createDummy(String status) {
				
		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		try {
			
			List<Applicant> a = adi.getApplicantList(status);
			for(Applicant x: a) {
				return x;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
		
	}*/

}