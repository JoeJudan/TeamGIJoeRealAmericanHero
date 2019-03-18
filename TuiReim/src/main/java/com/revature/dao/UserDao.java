package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;


public interface UserDao {
	
	//CRUD
		//this method we need to place an insert method, here we need a name, id would be sequence
		public abstract void createUser(User u)throws SQLException;
		//
		public abstract List<User> getUserList(int eid) throws SQLException;
		public abstract List<User> userSearch(String userName, String passWord) throws SQLException;
		public abstract int getEmployeeID(String userName, String passWord) throws SQLException;
}
