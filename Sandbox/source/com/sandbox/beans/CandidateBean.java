package com.sandbox.beans;

import com.sandbox.utils.Constants;

public class CandidateBean {
	
	private String namePrefix;
	private String nameFirst;
	private String nameMiddle;
	private String nameLast;
	private String skills;
	private String addrType;
	private String addrLocCountryRegion;
	private String addrLocState;
	private String addrLocCity;
	private String addrPostalCode;
	private String email;
	private String website;
	
	public CandidateBean() {
		
		namePrefix = Constants.EMPTY_STRING;
		nameFirst = Constants.EMPTY_STRING;
		nameMiddle = Constants.EMPTY_STRING;
		nameLast = Constants.EMPTY_STRING;
		skills = Constants.EMPTY_STRING;
		addrType = Constants.EMPTY_STRING;
		addrLocCountryRegion = Constants.EMPTY_STRING;
		addrLocState = Constants.EMPTY_STRING;
		addrLocCity = Constants.EMPTY_STRING;
		addrPostalCode = Constants.EMPTY_STRING;
		email = Constants.EMPTY_STRING;
		website = Constants.EMPTY_STRING;
		
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameMiddle() {
		return nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddrLocCountryRegion() {
		return addrLocCountryRegion;
	}

	public void setAddrLocCountryRegion(String addrLocCountryRegion) {
		this.addrLocCountryRegion = addrLocCountryRegion;
	}

	public String getAddrLocState() {
		return addrLocState;
	}

	public void setAddrLocState(String addrLocState) {
		this.addrLocState = addrLocState;
	}

	public String getAddrLocCity() {
		return addrLocCity;
	}

	public void setAddrLocCity(String addrLocCity) {
		this.addrLocCity = addrLocCity;
	}

	public String getAddrPostalCode() {
		return addrPostalCode;
	}

	public void setAddrPostalCode(String addrPostalCode) {
		this.addrPostalCode = addrPostalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}