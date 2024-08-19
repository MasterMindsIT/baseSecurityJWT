package com.base.mappers;

import com.base.dtos.UserDTOResponse;
import com.base.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper INSTANCE  = Mappers.getMapper(UserMapper.class);
    UserDTOResponse userToDTO(UserEntity userEntity);
    UserEntity userDTOToUserEntity(UserDTOResponse userDTOResponse);
}
