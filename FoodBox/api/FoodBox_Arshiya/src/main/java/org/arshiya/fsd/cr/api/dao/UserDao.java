package org.arshiya.fsd.cr.api.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;

public interface UserDao {

	User getUser(String email) throws FoodBoxDaoException;

	User getUser(String email, String password) throws FoodBoxDaoException;

	User save(User user) throws FoodBoxDaoException;

	List<User> getUsers() throws FoodBoxDaoException;

	List<User> getUsersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxDaoException;

}
