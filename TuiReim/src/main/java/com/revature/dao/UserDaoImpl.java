package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConFactory;

public class UserDaoImpl implements UserDao {

public static ConFactory cf=ConFactory.getInstance();
	

	public UserDaoImpl() {

	}

	public void createUser(User u)throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTUSER(?, ?, ?, ?, ?, ?)";
		CallableStatement call=conn.prepareCall(sql);
		
		call.setString(1, u.getFirstName());
		call.setString(2, u.getLastName());
		call.setString(3, u.getUserName());
		call.setString(4, u.getPassWord());
		call.setString(5, u.getEmail());
		call.setInt(6, u.getUserType());
		call.execute();		
	}
	
	public List<User> getUserList(int employeeID) throws SQLException {
	
		List<User> userList = new ArrayList<User>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM USERTABLE WHERE EIDNUMBER = '"+employeeID+"'");
		User s=null;
		
		while(rs.next()) {
			s=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			userList.add(s);
		}
		
		return userList;
	}
	
	public List<User> userSearch(String userName, String passWord) throws SQLException{
		
		List<User> userList = new ArrayList<User>();// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT USERID FROM USERTABLE WHERE USERNAME ='"+userName+"' AND PASSWORD1='"+passWord+"'");
		User s=null;
		
		while(rs.next()) {
			s=new User(rs.getString(4), rs.getString(5));
			userList.add(s);
		}
		return userList;
	}
	
	public int getEmployeeID(String userName, String passWord) throws SQLException{
		
		int b=0;
		Connection con = cf.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT EIDNUMBER FROM USERTABLE WHERE USERNAME ='"+userName+"' AND PASSWORD1='"+passWord+"'");
		if(rs.next()) {
			 b = rs.getInt(1);
		}
		return b;	
	}
	public int getEmployeeId(String userName) throws SQLException{
		
		int b=0;
		Connection con = cf.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT EIDNUMBER FROM USERTABLE WHERE USERNAME ='"+userName+"'");
		if(rs.next()) {
			 b = rs.getInt(1);
		}
		return b;	
	}
	
	
	public User getUserObject(String userName) throws SQLException{
		
		
		Connection con = cf.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM USERTABLE WHERE USERNAME ='"+userName+"'");
		User obj = null;
		if(rs.next()) {
			 obj =new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
		}
		return obj;	
	}
	
	public String getEmployeeName(String userName, String passWord) throws SQLException{
		
		String b = null;
		Connection con = cf.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT FIRSTNAME FROM USERTABLE WHERE USERNAME ='"+userName+"' AND PASSWORD1='"+passWord+"'");
		if(rs.next()) {
			 b = rs.getString(1);
			 return b;
		}else
			return b;	
	}
	
	public User employeeLogin(String userName, String passWord) throws SQLException{
	
		Connection con = cf.getConnection();
		
		User use = new User();
		
		String str = "SELECT * FROM USERTABLE WHERE USERNAME = ? AND  PASSWORD1= ?";
		
		PreparedStatement stmt = con.prepareStatement(str);
		stmt.setString(1, userName);
		stmt.setString(2, passWord);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			use.setEidNumber(rs.getInt(1));
			use.setFirstName(rs.getString(2));
			use.setLastName(rs.getString(3));
			use.setUserName(rs.getString(4));
			use.setPassWord(rs.getString(5));
			use.setEmail(rs.getString(6));
			use.setUserType(rs.getInt(7));
			
		}
		
		
		return use;
	}
}
