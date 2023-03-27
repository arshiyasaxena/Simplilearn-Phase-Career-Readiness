package com.arshiya.cr.icinbank.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiya.cr.icinbank.dao.UserRepository;
import com.arshiya.cr.icinbank.details.LoginDetails;
import com.arshiya.cr.icinbank.model.User;
import com.arshiya.cr.icinbank.response.LoginResponse;
import com.arshiya.cr.icinbank.service.LoginService;

import org.apache.commons.codec.digest.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository dao;
	
	@Override
	public LoginResponse customerLogin(LoginDetails login){
		LoginResponse response = new LoginResponse();
		boolean flag = true;
		String message = "Login succesfull";
		User user = null;
		String hashedPassword = DigestUtils.sha256Hex(login.getPassword());
		try {
			user=dao.findByUsername(login.getUsername());
			if(user.getStatus()) {
				flag = false;
				message = "Dear Mr/Ms."+user.getFname()+" your account has been blocked for security reasons.";
			}
			if(!user.getAuthorizationStatus()) {
				flag = false;
				message = "Dear Mr/Ms."+user.getFname()+" your account has not been activated yet";
			}
			if(!hashedPassword.equals(user.getPassword())) {
				flag = false;
				message = "Username or password is incorrect";
			}
		} 
		catch (Exception e) {
			flag = false;
			message = "Username or password is incorrect";
		}
		
		response.setLoginStatus(flag);
		response.setResponseMessage(message);
		try {
			response.setUsername(user.getUsername());
		} catch (Exception e) {
			response.setUsername(login.getUsername());
		}
		return response;
	}

}