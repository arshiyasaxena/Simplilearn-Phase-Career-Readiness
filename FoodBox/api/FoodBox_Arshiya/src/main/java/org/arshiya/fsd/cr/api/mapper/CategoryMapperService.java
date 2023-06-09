package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapperService {

	default org.arshiya.fsd.cr.api.entity.Category findById(Long id) {
		if (id == null) {
			return null;
		}

		org.arshiya.fsd.cr.api.entity.Category category = new org.arshiya.fsd.cr.api.entity.Category();
		category.setId(id);

		return category;
	}

	default Long findByCategory(org.arshiya.fsd.cr.api.entity.Category category) {
		if (category == null) {
			return null;
		}

		return category.getId();
	}

}
