package com.sandbox.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sandbox.beans.CandidateBean;
import com.sandbox.beans.HrEmployeeBean;
import com.sandbox.connection.DatabaseMSSQL;
import com.sandbox.utils.Constants;
import com.sandbox.utils.PropertyUtils;

public class HrService {
	
	private PropertyUtils propertyUtils;
	
	public List<HrEmployeeBean> getHrEmployee() {
		
		List<HrEmployeeBean> humanResourcesEmployeeList = new ArrayList<HrEmployeeBean>();
		HrEmployeeBean hrEmployeeBean = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		connection = DatabaseMSSQL.getConnection();
		
		try {
			
			propertyUtils = new PropertyUtils();
			preparedStatement = connection.prepareStatement(propertyUtils.getPropertyValue("db.get.hr.employees"));
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				hrEmployeeBean = new HrEmployeeBean();
				
				hrEmployeeBean.setFirstName(resultSet.getString(Constants.FIRST_NAME));
				hrEmployeeBean.setMiddleName(resultSet.getString(Constants.MIDDLE_NAME));
				hrEmployeeBean.setLastName(resultSet.getString(Constants.LAST_NAME));
				hrEmployeeBean.setJobTitle(resultSet.getString(Constants.JOB_TITLE));
				hrEmployeeBean.setPhoneNumber(resultSet.getString(Constants.PHONE_NUMBER));
				hrEmployeeBean.setPhoneNumberType(resultSet.getString(Constants.PHONE_NUMBER_TYPE));
				hrEmployeeBean.setEmailAddress(resultSet.getString(Constants.EMAIL_ADDRESS));
				hrEmployeeBean.setAddressLine1(resultSet.getString(Constants.ADDRESS_LINE_1));
				hrEmployeeBean.setCity(resultSet.getString(Constants.CITY));
				hrEmployeeBean.setStateProvinceName(resultSet.getString(Constants.STATE_PROVINCE_NAME));
				hrEmployeeBean.setPostalCode(resultSet.getString(Constants.POSTAL_CODE));
				hrEmployeeBean.setCountryRegionName(resultSet.getString(Constants.COUNTRY_REGION_NAME));
				
				humanResourcesEmployeeList.add(hrEmployeeBean);
				
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
			
		} finally {
			DatabaseMSSQL.closeResultSet(resultSet);
			DatabaseMSSQL.closePreparedStatement(preparedStatement);
			DatabaseMSSQL.closeConnection(connection);		
		}
		
		return humanResourcesEmployeeList;
		
	}
	
	public List<CandidateBean> getCandidates() {
		
		List<CandidateBean> candidateList = new ArrayList<CandidateBean>();
		CandidateBean candidateBean = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		connection = DatabaseMSSQL.getConnection();
		
		try {
			
			propertyUtils = new PropertyUtils();
			preparedStatement = connection.prepareStatement(propertyUtils.getPropertyValue("db.get.hr.candidates"));
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				candidateBean = new CandidateBean();
				
				candidateBean.setNamePrefix(resultSet.getString("Name.Prefix"));
				candidateBean.setNameFirst(resultSet.getString("Name.First"));
				candidateBean.setNameMiddle(resultSet.getString("Name.Middle"));
				candidateBean.setNameLast(resultSet.getString("Name.Last"));
				candidateBean.setSkills(resultSet.getString("Skills"));
				candidateBean.setAddrType(resultSet.getString("Addr.Type"));
				candidateBean.setAddrLocCountryRegion(resultSet.getString("Addr.Loc.CountryRegion"));
				candidateBean.setAddrLocState(resultSet.getString("Addr.Loc.State"));
				candidateBean.setAddrLocCity(resultSet.getString("Addr.Loc.City"));
				candidateBean.setAddrPostalCode(resultSet.getString("Addr.PostalCode"));
				candidateBean.setEmail(resultSet.getString("EMail"));
				candidateBean.setWebsite(resultSet.getString("WebSite"));
								
				candidateList.add(candidateBean);
				
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
			
		} finally {
			DatabaseMSSQL.closeResultSet(resultSet);
			DatabaseMSSQL.closePreparedStatement(preparedStatement);
			DatabaseMSSQL.closeConnection(connection);		
		}
		
		return candidateList;
		
	}
}