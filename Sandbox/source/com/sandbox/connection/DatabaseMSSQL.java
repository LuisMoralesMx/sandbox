package com.sandbox.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sandbox.utils.Constants;

public class DatabaseMSSQL {
	
	private static Connection connection;

	private static String dbServer = Constants.EMPTY_STRING;
	private static String dbDriver = Constants.EMPTY_STRING;
	
	public static Connection getConnection() {

		try {
			
			dbServer = Constants.DB_MSSQL_SERVER;
			dbDriver = Constants.DB_MSSQL_DRIVER;
			
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbServer);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		if(connection != null) {
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		
		if(preparedStatement != null) {
			
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}	
	
	public static void closeResultSet(ResultSet resultSet) {
		
		if(resultSet != null) {
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}