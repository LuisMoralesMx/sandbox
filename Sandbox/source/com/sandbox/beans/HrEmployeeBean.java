package com.sandbox.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sandbox.utils.Constants;

@ManagedBean(name="hrEmployeeBean")
@SessionScoped
public class HrEmployeeBean {
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String personType;
	private String emailAddress;	
	private String jobTitle;
	private String phoneNumber;
	private String phoneNumberType;
	private String addressLine1;
	private String city;
	private String stateProvinceName;
	private String postalCode;
	private String countryRegionName;
	
	public HrEmployeeBean() {
		
		firstName = Constants.EMPTY_STRING;
		lastName = Constants.EMPTY_STRING;
		middleName = Constants.EMPTY_STRING;
		personType = Constants.EMPTY_STRING;
		emailAddress = Constants.EMPTY_STRING;		
		jobTitle = Constants.EMPTY_STRING;
		phoneNumber = Constants.EMPTY_STRING;
		phoneNumberType = Constants.EMPTY_STRING;
		addressLine1 = Constants.EMPTY_STRING;
		city = Constants.EMPTY_STRING;
		stateProvinceName = Constants.EMPTY_STRING;
		postalCode = Constants.EMPTY_STRING;
		countryRegionName= Constants.EMPTY_STRING;
		
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvinceName() {
		return stateProvinceName;
	}

	public void setStateProvinceName(String stateProvinceName) {
		this.stateProvinceName = stateProvinceName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryRegionName() {
		return countryRegionName;
	}

	public void setCountryRegionName(String countryRegionName) {
		this.countryRegionName = countryRegionName;
	}
}