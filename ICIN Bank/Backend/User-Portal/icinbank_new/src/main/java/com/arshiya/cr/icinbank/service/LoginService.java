package com.arshiya.cr.icinbank.service;

import com.arshiya.cr.icinbank.details.LoginDetails;
import com.arshiya.cr.icinbank.response.LoginResponse;

public interface LoginService {

	public LoginResponse customerLogin(LoginDetails details);
}
