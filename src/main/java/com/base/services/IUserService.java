package com.base.services;

import com.base.dtos.UserDTO;
import com.base.dtos.UserDTOResponse;
import com.base.entities.UserEntity;

import java.util.List;

public interface IUserService {
   List<UserEntity> getAll();
   UserEntity getById(Long id);
   UserDTOResponse save(UserDTO user);
   UserEntity update(Long id, UserDTO user);
   boolean deleteById(Long id);
}
