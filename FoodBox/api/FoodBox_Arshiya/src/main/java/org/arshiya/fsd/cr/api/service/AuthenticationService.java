package org.arshiya.fsd.cr.api.service;

import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

public interface AuthenticationService {

	User login(String email, String password, String role) throws FoodBoxServiceException;

	User register(User user) throws FoodBoxServiceException;

}
