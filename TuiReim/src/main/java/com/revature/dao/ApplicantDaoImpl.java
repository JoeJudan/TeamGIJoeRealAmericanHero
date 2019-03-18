package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.beans.Applicant;
import com.revature.util.ConFactory;

public class ApplicantDaoImpl implements ApplicantDao{
	
public static ConFactory cf=ConFactory.getInstance();
	
	public void createApplication(Applicant a)throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "{ call CREATEAPPLICATION(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		CallableStatement call=conn.prepareCall(sql);

		call.setString(1, a.getFirstName());
		call.setString(2, a.getLastName());
		call.setString(3, a.getLocation());
		call.setString(4, a.getDescription());
		call.setDouble(5, a.getAmount());
		call.setString(6, a.getEventType());
		call.setString(7, a.getEventTime());
		call.setString(8, a.getGradeFormat());
		call.setString(9, a.getGrade());
		call.setInt(10, a.getEidNumber());
		call.setString(11, a.getStatus());
		call.setString(12, a.getReason());
		call.setInt(13, a.getEidNumber());

		call.execute();	
	}
	
	public List<Applicant> getApplicantList(int employeeID) throws SQLException {
		
		List<Applicant> applicantList = new ArrayList<Applicant>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT WHERE EIDNUMBER = '"+employeeID+"'");
		Applicant s=null;
		System.out.println("This gets reached");
		while(rs.next()) {
			s=new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12),  rs.getString(13), rs.getString(14), rs.getInt(15));
			applicantList.add(s);
		}
		
		return applicantList;
	}
	
	public Applicant getSingleApplicant(int applId) throws SQLException {
		
		//List<Applicant> applicantList = new ArrayList<Applicant>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT WHERE AIDNUMBER='"+applId+"'");
		Applicant s=null;
		System.out.println("This gets reached");
		while(rs.next()) {
			s=new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12),  rs.getString(13), rs.getString(14), rs.getInt(15));
			return s;
		}
		
		return null;
	}
	
		public boolean validation(int applId) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "SELECT * APPLICANT WHERE APPLICANT AIDNUMBER='"+ applId+"'";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		boolean check = false; 
		while(rs.next()) {
			check = true; 
			return check; 
		}
		return check;
	}
		
		public List<Applicant> getApplicantList(String status) throws SQLException {
			
			List<Applicant> applicantList = new ArrayList<Applicant>();// TODO Auto-generated method stub
			Connection conn= cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT WHERE STATUS = '"+status+"'");
			Applicant s=null;
			System.out.println("This gets reached");
			while(rs.next()) {
				s=new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12),  rs.getString(13), rs.getString(14), rs.getInt(15));
				applicantList.add(s);
			}
			
			return applicantList;
		}
		//dao to get all the applicansts 
		public List<Applicant> getApplicantList() throws SQLException {
			
			List<Applicant> applicantList = new ArrayList<Applicant>();// TODO Auto-generated method stub
			Connection conn= cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT");
			Applicant s=null;
			System.out.println("This gets reached");
			while(rs.next()) {
				s=new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12),  rs.getString(13), rs.getString(14), rs.getInt(15));
				applicantList.add(s);
			}
			
			return applicantList;
		}
		//dao to retrieve all applicants with their approval level = 1 and status = "pending"
		public List<Applicant> getApplicantList(String status, int loa) throws SQLException {
			
			List<Applicant> applicantList = new ArrayList<Applicant>();// TODO Auto-generated method stub
			Connection conn= cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT WHERE STATUS = '"+status+"' AND APPROVALLEVEL ='"+loa+"'");
			Applicant s=null;
			System.out.println("This gets reached");
			while(rs.next()) {
				s=new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12),  rs.getString(13), rs.getString(14), rs.getInt(15));
				applicantList.add(s);
			}
			
			return applicantList;
		}
		
		//dao to update the pending requests by benco
		public void updatePendingbybc(int applicationId, int amount) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call UPDATEREQUESTBYBC(?,?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.setInt(2, amount);
			call.execute();		
		}
				
		//dao to update the pending requests by benco
		public void updatePendingbyb(int applicationId) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call UPDATEREQUESTBYB(?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.execute();		
		}
		//dao to update the pending requests by department head
		public void updatePendingbydh(int applicationId) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call UPDATEREQUESTBYDH(?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.execute();		
		}
		//dao to update the pending requests 
		public void updatePending(int applicationId) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call UPDATEREQUEST(?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.execute();		
		}
		//dao to deny pending requests 
		public void denyRequest(int applicationId) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call DENYREQUEST(?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.execute();		
		}
		
		//dao to add reason 
		public void addReason(int applicationId, String reason) throws SQLException {
			Connection conn = cf.getConnection(); 
			String sql = "{ call ADDREASON(?,?)"; 
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, applicationId);
			call.setString(2, reason);
			call.execute();		
		}
}
