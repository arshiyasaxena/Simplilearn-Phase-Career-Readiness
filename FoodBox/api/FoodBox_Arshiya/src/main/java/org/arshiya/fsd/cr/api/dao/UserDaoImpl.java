package org.arshiya.fsd.cr.api.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;
import org.arshiya.fsd.cr.api.mapper.UserMapper;
import org.arshiya.fsd.cr.api.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private UserRepository repository;

	@Resource
	private UserMapper mapper;

	@Override
	public User getUser(String email) throws FoodBoxDaoException {
		User user = null;

		try {
			user = repository.findById(email)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return user;
	}

	@Override
	public User getUser(String email, String password) throws FoodBoxDaoException {
		User user = null;

		try {
			user = repository.findByEmailAndPassword(email, password)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return user;
	}

	@Override
	public User save(User user) throws FoodBoxDaoException {
		User savedUser = null;

		try {
			savedUser = mapper.toDto(repository.save(mapper.toEntity(user)));
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return savedUser;
	}

	@Override
	public List<User> getUsers() throws FoodBoxDaoException {
		List<User> users = null;

		try {
			users = repository.findAll()
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return users;
	}

	@Override
	public List<User> getUsersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxDaoException {
		List<User> users = null;

		try {
			users = repository.findAllByCreatedDateTimeBetween(start, end)
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return users;
	}

}
