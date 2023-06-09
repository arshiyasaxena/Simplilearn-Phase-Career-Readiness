package org.arshiya.fsd.cr.api.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dto.Order;
import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;
import org.arshiya.fsd.cr.api.mapper.OrderMapper;
import org.arshiya.fsd.cr.api.mapper.UserMapper;
import org.arshiya.fsd.cr.api.repository.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Resource
	private OrderRepository repository;

	@Resource
	private OrderMapper mapper;
	
	@Resource
	private UserMapper userMapper;

	@Override
	public Order getOrder(Long id) throws FoodBoxDaoException {
		Order order = null;

		try {
			order = repository.findById(id)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return order;
	}

	@Override
	public List<Order> getOrders() throws FoodBoxDaoException {
		List<Order> orders = null;

		try {
			orders = repository.findAll()
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return orders;
	}
	
	@Override
	public List<Order> getOrdersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxDaoException {
		List<Order> orders = null;

		try {
			orders = repository.findAllByCreatedDateTimeBetween(start, end)
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return orders;
	}
	
	@Override
	public List<Order> getOrdersByUser(User user) throws FoodBoxDaoException {
		List<Order> orders = null;

		try {
			orders = repository.findByUser(userMapper.toEntity(user))
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return orders;
	}
	
	@Override
	public List<Order> getOrdersByUserAndCreatedBetween(User user, LocalDateTime start, LocalDateTime end)
			throws FoodBoxDaoException {
		List<Order> orders = null;

		try {
			orders = repository.findByUserAndCreatedDateTimeBetween(userMapper.toEntity(user), start, end)
					.stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return orders;
	}

	@Override
	public Order save(Order order) throws FoodBoxDaoException {
		Order savedOrder = null;

		try {
			savedOrder = mapper.toDto(repository.save(mapper.toEntity(order)));
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return savedOrder;
	}

	@Override
	public void remove(Long id) throws FoodBoxDaoException {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}
	}

}
