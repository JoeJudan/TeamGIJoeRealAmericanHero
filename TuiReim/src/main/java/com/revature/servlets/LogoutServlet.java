package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class LogoutServlet
*/
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public LogoutServlet() {
       super();
   }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
//        HttpSession session1 = request.getSession(false);
//        session1.invalidate();
        
        if(session != null) {
            session.invalidate();
        }
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        request.getRequestDispatcher("index.html").include(request, response);
        pw.write("<p> You have successfully been logged out </p>");
        pw.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}