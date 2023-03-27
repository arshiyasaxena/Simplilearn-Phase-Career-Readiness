package org.arshiya.fsd.cr.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.arshiya.fsd.cr.api.dto.Order;
import org.arshiya.fsd.cr.api.dto.User;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

public interface OrderService {

	List<Order> getOrders() throws FoodBoxServiceException;

	List<Order> getOrdersCreatedBetween(LocalDateTime start, LocalDateTime end) throws FoodBoxServiceException;

	List<Order> getOrdersByUser(User user) throws FoodBoxServiceException;

	List<Order> getOrdersByUserAndCreatedBetween(User user, LocalDateTime start, LocalDateTime end)
			throws FoodBoxServiceException;

	Order getOrder(Long id) throws FoodBoxServiceException;

	Order createOrder(Order order) throws FoodBoxServiceException;

	Order updateOrder(Order order) throws FoodBoxServiceException;

	Order deleteOrder(Long id) throws FoodBoxServiceException;

}
