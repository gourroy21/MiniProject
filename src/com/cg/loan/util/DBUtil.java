package com.cg.loan.util;

import java.io.FileInputStream;
<<<<<<< HEAD
import java.io.FileNotFoundException;
=======
>>>>>>> eddb28e9aefda37c2842440210897810564d625f
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
<<<<<<< HEAD
public static Connection getConnection() {
		
		String driver="";
		String url="";
		String username="";
		String password="";
		
		Connection conn=null;
		
		try {
			FileInputStream fis= new FileInputStream("./resources/DatabaseConfig.properties");
			Properties prop=new Properties();
			prop.load(fis);
			
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
		
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			//System.out.println("Connected to DB...");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
		
=======
	public static Connection getConnection() {
			String driver="";
			String url="";
			String username="";
			String passwd="";
			Connection connection=null;
			try {
				FileInputStream fin=new FileInputStream("DBConfig.properties");
				Properties prop=new Properties();
				prop.load(fin);
				driver=prop.getProperty("driver");
				url=prop.getProperty("url");
				username=prop.getProperty("username");
				passwd=prop.getProperty("passwd");
				
				Class.forName(driver);
				connection=DriverManager.getConnection(url, username, passwd);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
			
	}
	public static void main(String[] args) {
		getConnection();
>>>>>>> eddb28e9aefda37c2842440210897810564d625f
	}

}
