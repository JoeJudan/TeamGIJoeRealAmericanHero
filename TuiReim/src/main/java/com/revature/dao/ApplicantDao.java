package com.revature.dao;

import java.sql.SQLException;
import java.util.List;



import com.revature.beans.Applicant;



public interface ApplicantDao {

	public abstract void createApplication(Applicant a)throws SQLException;
	//
	public abstract List<Applicant> getApplicantList(int emp) throws SQLException;
	//
	public abstract boolean validation(String password, String username) throws SQLException; 

}
