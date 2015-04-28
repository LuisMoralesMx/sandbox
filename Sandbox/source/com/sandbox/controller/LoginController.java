package com.sandbox.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.sandbox.beans.UserBean;
import com.sandbox.services.UserService;
import com.sandbox.utils.Constants;

public class LoginController implements Serializable {
	
	private static final long serialVersionUID = -2486325999473381608L;
	private UserBean userBean;
	
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
}