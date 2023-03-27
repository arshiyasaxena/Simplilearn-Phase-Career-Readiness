package com.arshiya.cr.icinbank.service;
import com.arshiya.cr.icinbank.model.User;
import com.arshiya.cr.icinbank.response.RegisterResponse;

public interface RegistrationService {

	public RegisterResponse createAccount(User details); 
	public boolean usernameAlreadyExists(String username);
	public boolean EmailAlreadyExists(String email);
	public boolean PhoneAlreadyExists(long l);
}
