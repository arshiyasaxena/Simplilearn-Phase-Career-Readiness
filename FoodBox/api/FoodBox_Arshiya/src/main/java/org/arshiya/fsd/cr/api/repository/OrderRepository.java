package org.arshiya.fsd.cr.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.arshiya.fsd.cr.api.entity.Order;
import org.arshiya.fsd.cr.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByCreatedDateTimeBetween(LocalDateTime createdDateTimeStart, LocalDateTime createdDateTimeEnd);

	List<Order> findByUser(User user);

	List<Order> findByUserAndCreatedDateTimeBetween(User user, LocalDateTime createdDateTimeStart,
			LocalDateTime createdDateTimeEnd);

}
