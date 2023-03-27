package org.arshiya.fsd.cr.api.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dao.UserDao;
import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUser(String email) throws FoodBoxServiceException {
		User user = null;

		try {
			user = userDao.getUser(email);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers() throws FoodBoxServiceException {
		List<User> users = null;

		try {
			users = userDao.getUsers();
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return users;
	}

	@Override
	@Transactional
	public List<User> getUsersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxServiceException {
		List<User> users = null;

		try {
			users = userDao.getUsersCreatedBetween(start, end);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return users;
	}

}
