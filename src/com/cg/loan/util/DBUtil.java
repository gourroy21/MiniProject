package com.cg.loan.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
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
	}

}
