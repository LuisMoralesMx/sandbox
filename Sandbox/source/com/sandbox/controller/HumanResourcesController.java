package com.sandbox.controller;
import java.io.Serializable;
import java.util.List;

import com.sandbox.beans.CandidateBean;
import com.sandbox.beans.HrEmployeeBean;
import com.sandbox.services.HrService;

public class HumanResourcesController implements Serializable {
	
	private static final long serialVersionUID = 7420266027939019353L;
	
	private List<HrEmployeeBean> hrEmployeeList;
	private List<CandidateBean> hrCandidateList;
	
	private HrEmployeeBean hrEmployeeBean;
	
	public String viewHrEmployees() {
		
		HrService userService = null;

		try {
			
			// Call Service & retrieve employee data
			userService = new HrService();
			setHrEmployeeList(userService.getHrEmployee());
			
			return "success";
			
		} catch (Exception ex) {
			System.out.println("An error has ocurred: " + ex);			
			return "error";
		}
	}
	
	public String viewHrCandidates() {
		
		HrService userService = null;
		
		try {
			
			// Call Service & pull retrieve candidates data
			userService = new HrService();
			setHrCandidateList(userService.getCandidates());
			
			return "success";
			
		} catch (Exception ex) {
			System.out.println("An error has ocurred: " + ex);			
			return "error";
		}		
	}

	public List<HrEmployeeBean> getHrEmployeeList() {
		return hrEmployeeList;
	}

	public void setHrEmployeeList(List<HrEmployeeBean> hrEmployeeList) {
		this.hrEmployeeList = hrEmployeeList;
	}

	public List<CandidateBean> getHrCandidateList() {
		return hrCandidateList;
	}

	public void setHrCandidateList(List<CandidateBean> hrCandidateList) {
		this.hrCandidateList = hrCandidateList;
	}

	public HrEmployeeBean getHrEmployeeBean() {
		return hrEmployeeBean;
	}

	public void setHrEmployeeBean(HrEmployeeBean hrEmployeeBean) {
		this.hrEmployeeBean = hrEmployeeBean;
	}
}