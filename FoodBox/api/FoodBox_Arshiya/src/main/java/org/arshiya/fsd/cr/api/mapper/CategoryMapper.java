package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper extends
		EntityDtoMapper<org.arshiya.fsd.cr.api.dto.Category, org.arshiya.fsd.cr.api.entity.Category> {

	@Mapping(target = "image", ignore = true)
	org.arshiya.fsd.cr.api.entity.Category toEntity(org.arshiya.fsd.cr.api.dto.Category dto);

	@Mapping(target = "image", ignore = true)
	org.arshiya.fsd.cr.api.dto.Category toDto(org.arshiya.fsd.cr.api.entity.Category entity);
	
}
