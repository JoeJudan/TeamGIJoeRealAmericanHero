package com.revature.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {
	
	private static ConFactory cf = new ConFactory();
	private ConFactory() {
		super();
	}
	
	public static synchronized ConFactory getInstance() {//if connection doesnt exist, make new connection
		if(cf==null) {
			cf=new ConFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn =null;
		//Properties prop = new Properties();
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@pega21119.cmujdqw2azh8.us-east-1.rds.amazonaws.com:1521:ORCL", 
					"joejudan", 
					"J4alJus7");
/*			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("password"));*/
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
