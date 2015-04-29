package com.sandbox.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.sandbox.beans.UserBean;
import com.sandbox.services.UserService;
import com.sandbox.utils.Constants;
import com.sandbox.utils.Utils;

public class LoginController implements Serializable {
	
	private static final long serialVersionUID = -2486325999473381608L;
	
	private UserBean userBean;
	private UserBean accountRegistrationBean;
	
	public String loginAccess() {
		
		Map<String, String> userMap = null;
		UserService userService = null;

		if(userBean.getUsername() != null && !userBean.getUsername().equals(Constants.EMPTY_STRING) 
				&& userBean.getPassword() != null && !userBean.getPassword().equals(Constants.EMPTY_STRING)) {	
			
			userService = new UserService();	
			userMap = new HashMap<String, String>();
			userMap = userService.getUserCredentials(userBean.getUsername(), userBean.getPassword());
			
			if(userMap != null) {
				
				if(userMap.get(Constants.SQLL_USER_NAME).equals(userBean.getUsername()) &&
						userMap.get(Constants.SQLL_PASSWORD).equals(userBean.getPassword())) {
					
					userBean.setFirstName(userMap.get(Constants.SQLL_FIRST_NAME));
					userBean.setLastName(userMap.get(Constants.SQLL_LAST_NAME));
					userBean.setEmail(userMap.get(Constants.SQLL_EMAIL));
					
					return "success";
					
				} else {
					return "failure";
				}
				
			} else {
				return "failure";
			}
			
		} else {
			return "failure";
		}
	}
	
	public void registerAccount(ActionEvent event) {
		
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		UserService userService = null;
				
		boolean registrationFlag = false;
		
		if(!Utils.isNullOrEmpty(accountRegistrationBean.getFirstName()) 
				&& !Utils.isNullOrEmpty(accountRegistrationBean.getLastName()) 
				&& !Utils.isNullOrEmpty(accountRegistrationBean.getEmail()) 
				&& !Utils.isNullOrEmpty(accountRegistrationBean.getUsername())
				&& !Utils.isNullOrEmpty(accountRegistrationBean.getPassword())) {
			
			userService = new UserService();
			userService.createUserAccount(accountRegistrationBean);
			
			registrationFlag = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome!", "Account registration was successful");
			
		} else {
			
			registrationFlag = false;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Error", "Please try again.");
			
		}	
		
		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam(Constants.CALLBACK_REGISTRATION_FLAG, registrationFlag);
		
	}
	
	public String logout() {
		return "/login.xhtml?faces-redirect=true";
	}
	
	public String returnHome() {
	    return "/faces/index.xhtml?faces-redirect=true";
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserBean getAccountRegistrationBean() {
		return accountRegistrationBean;
	}

	public void setAccountRegistrationBean(UserBean accountRegistrationBean) {
		this.accountRegistrationBean = accountRegistrationBean;
	}
}