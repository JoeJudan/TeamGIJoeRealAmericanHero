package com.revature.beans;

import java.sql.SQLException;

public class User {
	
	private int eidNumber;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private int userType;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(int eidNumber) {
		super();
		this.eidNumber = eidNumber;
	}




	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(String firstName, String lastName, String userName, String passWord, String email) {
		this(0, userName, passWord, firstName, lastName, email, 1);
	}//call this one


	public User(int eidNumber, String userName, String passWord, String firstName, String lastName, String email,
			int userType) {
		super();
		this.eidNumber = eidNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
	}
	
	


	public int getEidNumber() {
		return eidNumber;
	}
	public void setEidNumber(int eidNumber) {
		this.eidNumber = eidNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [eidNumber=" + eidNumber + ", userName=" + userName + ", passWord=" + passWord + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userType=" + userType + "]";
	}
	
	/*public int approve(Application r) {
		ApplicationDaoImpl r_dao = new ApplicationDaoImpl();
		if(r.getStatus() == getStatus()) {
			try {
				return r_dao.updateStatus(r.getRequestId(), getStatus()+1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}
	
	public int deny(Request r) {
		RequestDaoImpl r_dao = new RequestDaoImpl();
		if(r.getStatus() == getStatus()) {
			try {
				return r_dao.updateStatus(r.getRequestId(), 0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}*/

}
