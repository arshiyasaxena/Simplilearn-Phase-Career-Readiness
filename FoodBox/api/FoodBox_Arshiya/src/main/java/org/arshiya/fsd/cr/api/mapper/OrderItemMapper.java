package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;

@Mapper(uses = { FoodMapper.class })
public interface OrderItemMapper extends
		EntityDtoMapper<org.arshiya.fsd.cr.api.dto.OrderItem, org.arshiya.fsd.cr.api.entity.OrderItem> {

	org.arshiya.fsd.cr.api.entity.OrderItem toEntity(org.arshiya.fsd.cr.api.dto.OrderItem dto);

	org.arshiya.fsd.cr.api.dto.OrderItem toDto(org.arshiya.fsd.cr.api.entity.OrderItem entity);

}
