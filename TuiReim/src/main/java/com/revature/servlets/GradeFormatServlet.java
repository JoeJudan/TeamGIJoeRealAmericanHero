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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.GradeFormat;
import com.revature.dao.ApplicantDaoImpl;

/**
 * Servlet implementation class GradeFormatServlet
 */
public class GradeFormatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeFormatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet of GradeFormatServlet");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of GradeFormatServlet");
		
		ObjectMapper mapper1 = new ObjectMapper();
		ApplicantDaoImpl gfdi  = new ApplicantDaoImpl();
		
		String grade = request.getParameter("grade");
		String etype = request.getParameter("etype");
		
		
		int result = getResultMethod(grade, etype);
		
		try {
			
			String decision = gfdi.getDec(result);
			System.out.println("This is result: "+decision);
			String jsonString = mapper1.writeValueAsString(decision);
			
			
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonString);

			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

/*		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);
		request.getRequestDispatcher("home.html").forward(request, response);*/
	}

	private int getResultMethod(String grade, String etype) {
		// TODO Auto-generated method stub
		int result = 0;

		switch (etype) {
		case "universitycourses":
			if(grade.equals("under70")){
				result = 3;
			}
			else
				if(grade.equals("between70to79")){
					result = 4;
				}
				else
					result = 5;
			break;
		case "seminars":
			result = 10;
			break;
		case "certificationpreparation":
			result = 9;
			break;
		case "certification":
			if(grade.equals("over79")){
				result = 2;
			}
			else{
				result = 1;
			}
			break;
		case "technicaltraining":
			if(grade.equals("under70")){
				result = 6;
			}
			else
				if(grade.equals("between70to79")){
					result = 7;
				}
				else
					result = 8;
			break;
		case "others":
			result = 11;
			break;
		default:
			System.out.println("Error in js");
		}
		
		System.out.println("This is the result "+result);
		return result;
	}
	

}

