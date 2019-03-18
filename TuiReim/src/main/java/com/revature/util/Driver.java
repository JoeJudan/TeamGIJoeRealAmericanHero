package com.revature.util;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Applicant;
import com.revature.beans.User;
import com.revature.dao.ApplicantDaoImpl;
import com.revature.dao.UserDaoImpl;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		
		
		
		String status="pending";
		ObjectMapper mapper = new ObjectMapper();
		
		
		

		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		
		
		List<Applicant> a = adi.getApplicantList(status);
		try {
			
			String jsonString = mapper.writeValueAsString(a);
			
			System.out.println(jsonString);
			
		
		
		
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

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
		
	/*	ObjectMapper mapper = new ObjectMapper();
		User user= createDummy();
		//System.out.println(user);
		UserDaoImpl udi = new UserDaoImpl();
		
		User use = new User();
		
		use = udi.getUserObject("hanz");
		System.out.println(use);
		try {
			String jsonString = mapper.writeValueAsString(user);
			System.out.println(jsonString);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	private static User createDummy() {
		
		int id = 10123;
		
		UserDaoImpl udi = new UserDaoImpl();
		try {;
			List<User> a = udi.getUserList(id);
			for(User x: a) {
				return x;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;		*/
		

		
/*		// TODO Auto-generated method stub
		Scanner f = new Scanner(System.in);
		
		@SuppressWarnings("deprecation")
		Date date = new Date(0, 0, 0);
	        		
		System.out.println("Please enter the following information: ");		
		System.out.println("Choose a username: ");
		String uname = f.nextLine();
		System.out.println("Choose a password: ");
		String pword = f.nextLine();
		System.out.println("What is your first name? ");
		String fname = f.nextLine();
		
		System.out.println("What is your last name? ");
		String lname = f.nextLine();

		System.out.println("What is your Email? ");
		String email = f.nextLine();
		
		System.out.println("What location are you in? ");
		String location = f.nextLine();
		System.out.println("What is the description? ");
		String description = f.nextLine();
		
		System.out.println("Type of reimbursement: ");
		String eventtype = f.nextLine();
		

		String eventtime = date.toString();
		
		System.out.println("\n\nAmount requested: ");
		//float amount = f.nextFloat();
		String amount = f.nextLine();
		
		System.out.println("this is the amount: "+ amount);
		
		double ramount = Double.parseDouble(amount);

		
		System.out.println("this is the amount after casting: "+ ramount);
		
		
		System.out.println("Your user account has been created and your request has been submitted\n\n\n\n");
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		User u = new User(fname, lname, uname, pword, email);

		UserDaoImpl udi = new UserDaoImpl();
		udi.createUser(u);
		int eid = udi.getEmployeeID(uname, pword);
		
		System.out.println("This is the damnd employee ID: "+eid);
		
		Applicant a = new Applicant(fname, lname, location, description, ramount, eventtype, eventtime, eid);
		
		ApplicantDaoImpl adi = new ApplicantDaoImpl();
		adi.createApplication(a);
		
		List<Applicant> alist = adi.getApplicantList();
		for(Applicant b: alist) {
			System.out.println(b);
		}
		List<User> ulist = udi.getUserList(eid);
		for(User c: ulist) {
			System.out.println(c);
		}
		
		f.close();
	}
}
*/