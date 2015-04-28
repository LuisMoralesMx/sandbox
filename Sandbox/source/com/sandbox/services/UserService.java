package com.sandbox.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.sandbox.connection.DatabaseSQLLite;
import com.sandbox.utils.Constants;
import com.sandbox.utils.PropertyUtils;

public class UserService {
	
	private PropertyUtils propertyUtils;
	
	public Map<String, String> getUserCredentials(String username, String password) {
		
		Map<String, String> userData = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		connection = DatabaseSQLLite.getConnection();
		
		try {
			
			propertyUtils = new PropertyUtils();
			preparedStatement = connection.prepareStatement(propertyUtils.getPropertyValue("db.get.user.credentials"));
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				userData = new HashMap<String, String>();
				
				userData.put(Constants.SQLL_FIRST_NAME, resultSet.getString(Constants.SQLL_FIRST_NAME));
				userData.put(Constants.SQLL_LAST_NAME, resultSet.getString(Constants.SQLL_LAST_NAME));
				userData.put(Constants.SQLL_EMAIL, resultSet.getString(Constants.SQLL_EMAIL));
				userData.put(Constants.SQLL_USER_NAME, resultSet.getString(Constants.SQLL_USER_NAME));
				userData.put(Constants.SQLL_PASSWORD, resultSet.getString(Constants.SQLL_PASSWORD));
				
			}

		} catch(Exception ex) {
			System.out.println(ex);
			
		} finally {
			DatabaseSQLLite.closeResultSet(resultSet);
			DatabaseSQLLite.closePreparedStatement(preparedStatement);
			DatabaseSQLLite.closeConnection(connection);		
		}
		
		return userData;
	}
}