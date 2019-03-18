package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

	public class Helper {
		
		public static String process(HttpServletRequest request) {
			HttpSession session1 = request.getSession(); 
			String destination = (String) session1.getAttribute("destination");
			switch(destination) {
			case "directory":
				return "directory"; // no need for breaks because of return statements
			case "new":
				return "new";
			case "request":
				return "request";
			case "allpending":
				return "allpending";
			case "allresolved":
				return "allresolved";
			case "updaterequest":
				return "updaterequest";
			default:
				return "home";
			}
		}

}
