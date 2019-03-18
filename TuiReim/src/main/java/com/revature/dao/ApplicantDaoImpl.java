package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.beans.Applicant;
import com.revature.beans.GradeFormat;
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

		@Override
		public boolean validation(String password, String username) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		

		public void updateGrade(int eid, String grade)throws SQLException {
			
			Connection con = cf.getConnection();
			
			Statement stmt=con.createStatement();
			stmt.executeQuery("UPDATE APPLICANT SET GRADE = '"+grade+"' WHERE EIDNUMBER = '"+eid+"'");
			// TODO Auto-generated method stub
			
		}
		
		public String getDec(int grade) throws SQLException{
			
			String b=null;
			Connection con = cf.getConnection();
			
			Statement stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT DECISION FROM GRADEFORMAT WHERE GRADEID  = "+grade);
			if(rs.next()) {
				 b = rs.getString(1);
			}
			return b;	
		}
		
		public List<GradeFormat> getGradeFormat(String status) throws SQLException {
			
			List<GradeFormat> gradeFormatList = new ArrayList<GradeFormat>();// TODO Auto-generated method stub
			Connection conn= cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM APPLICANT WHERE STATUS = '"+status+"'");
			GradeFormat s=null;
			System.out.println("This gets reached");
			while(rs.next()) {
				s=new GradeFormat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				gradeFormatList.add(s);
			}
			
			return gradeFormatList;
		}


}
