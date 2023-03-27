package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper
		extends EntityDtoMapper<org.arshiya.fsd.cr.api.dto.User, org.arshiya.fsd.cr.api.entity.User> {

}
