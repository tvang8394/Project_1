package dev.vang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	// following the singleton design pattern;
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			//Check if a connection exists
			if (connection == null) {
				/*
				 * hot fix to ensure driver loads correctly;
				 * */
				Class.forName("org.postgresql.Driver");
				
				//In order to establish a connection to our DB
				//we need our credentials
				// url (endpoint), username, password
				Properties props = new Properties();
				
				InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");
				
				props.load(input);
				
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				connection = DriverManager.getConnection(url, username, password);
				
				return connection;
			} else {
				return connection;
			}
		}catch(SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn = JDBCConnection.getConnection();
		
		if (conn != null) {
			System.out.println("Connected");
		} else {
			System.out.println("Not Connected");
		}
	}
}

