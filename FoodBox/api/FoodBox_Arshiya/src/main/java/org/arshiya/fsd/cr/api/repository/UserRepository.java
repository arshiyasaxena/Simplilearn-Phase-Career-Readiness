package org.arshiya.fsd.cr.api.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.arshiya.fsd.cr.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmailAndPassword(String email, String password);

	List<User> findAllByCreatedDateTimeBetween(LocalDateTime createdDateTimeStart, LocalDateTime createdDateTimeEnd);

}
