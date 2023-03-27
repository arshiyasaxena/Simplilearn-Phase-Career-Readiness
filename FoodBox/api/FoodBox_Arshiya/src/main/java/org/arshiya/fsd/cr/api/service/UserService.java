package org.arshiya.fsd.cr.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

public interface UserService {

	User getUser(String email) throws FoodBoxServiceException;

	List<User> getUsers() throws FoodBoxServiceException;

	List<User> getUsersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxServiceException;

}
