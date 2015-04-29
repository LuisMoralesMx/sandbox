package com.sandbox.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.sandbox.beans.UserBean;
import com.sandbox.connection.DatabaseSQLLite;
import com.sandbox.utils.Constants;
import com.sandbox.utils.PropertyUtils;

public class UserService {
	
	private PropertyUtils propertyUtils;
	
	public Boolean createUserAccount(UserBean accountRegistrationBean) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int updateCount = 0;
		boolean registrationFlag = false;
		
		connection = DatabaseSQLLite.getConnection();
		
		try {
			
			propertyUtils = new PropertyUtils();
			preparedStatement = connection.prepareStatement(propertyUtils.getDbPropertyValue("db.insert.user.credentials"));
			preparedStatement.setString(1, accountRegistrationBean.getFirstName());
			preparedStatement.setString(2, accountRegistrationBean.getLastName());
			preparedStatement.setString(3, accountRegistrationBean.getEmail());
			preparedStatement.setString(4, accountRegistrationBean.getUsername());
			preparedStatement.setString(5, accountRegistrationBean.getPassword());
			
			updateCount = preparedStatement.executeUpdate();
			
			if(updateCount > 0) {
			    registrationFlag = true;
			}
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return registrationFlag;
	}
	
	public Map<String, String> getUserCredentials(String username, String password) {
		
		Map<String, String> userData = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		connection = DatabaseSQLLite.getConnection();
		
		try {
			
			propertyUtils = new PropertyUtils();
			preparedStatement = connection.prepareStatement(propertyUtils.getDbPropertyValue("db.get.user.credentials"));
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