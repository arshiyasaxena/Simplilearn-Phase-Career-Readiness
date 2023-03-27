package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapperService {

	default org.arshiya.fsd.cr.api.entity.User findById(String email) {
		if (email == null) {
			return null;
		}

		org.arshiya.fsd.cr.api.entity.User user = new org.arshiya.fsd.cr.api.entity.User();
		user.setEmail(email);

		return user;
	}

	default String findByUser(org.arshiya.fsd.cr.api.entity.User user) {
		if (user == null) {
			return null;
		}

		return user.getEmail();
	}

}
