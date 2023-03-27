package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { CategoryMapperService.class, OfferMapperService.class })
public interface FoodMapper
		extends EntityDtoMapper<org.arshiya.fsd.cr.api.dto.Food, org.arshiya.fsd.cr.api.entity.Food> {

	@Mapping(source = "categoryId", target = "category")
	@Mapping(source = "offerId", target = "offer")
	@Mapping(target = "image", ignore = true)
	org.arshiya.fsd.cr.api.entity.Food toEntity(org.arshiya.fsd.cr.api.dto.Food dto);

	@Mapping(source = "category", target = "categoryId")
	@Mapping(source = "offer", target = "offerId")
	@Mapping(target = "image", ignore = true)
	org.arshiya.fsd.cr.api.dto.Food toDto(org.arshiya.fsd.cr.api.entity.Food entity);
}
