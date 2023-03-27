package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { OrderItemMapper.class, UserMapperService.class })
public interface OrderMapper
		extends EntityDtoMapper<org.arshiya.fsd.cr.api.dto.Order, org.arshiya.fsd.cr.api.entity.Order> {

	@Mapping(source = "userId", target = "user")
	org.arshiya.fsd.cr.api.entity.Order toEntity(org.arshiya.fsd.cr.api.dto.Order dto);

	@Mapping(source = "user", target = "userId")
	org.arshiya.fsd.cr.api.dto.Order toDto(org.arshiya.fsd.cr.api.entity.Order entity);

}
