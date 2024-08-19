package com.base.services.impl;

import com.base.dtos.UserDTO;
import com.base.dtos.UserDTOResponse;
import com.base.entities.RoleEntity;
import com.base.entities.UserEntity;
import com.base.mappers.UserMapper;
import com.base.repositories.RoleRepository;
import com.base.repositories.UserRepository;
import com.base.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        log.info("Iniciando servicio: " + this.getClass().getName());
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException("Elemento no encontrado"));
    }

    @Override
    public UserDTOResponse save(UserDTO userDto) {
        List<String> rolesRequest = userDto.roleRequest().roleListName();
        Set<RoleEntity> roleEntityList = new HashSet<>(roleRepository.findRoleEntitiesByNameIn(rolesRequest));
        if (roleEntityList.isEmpty()) {
            roleEntityList.add(roleRepository.findByName("USER"));
        }
        UserEntity user = UserEntity.builder()
                .username(userDto.username())
                .email(userDto.email())
                .password(passwordEncoder.encode(userDto.password()))
                .isEnabled(userDto.isEnabled())
                .accountNoLocked(userDto.accountNoLocked())
                .credentialNoExpired(userDto.credentialNoExpired())
                .accountNoExpired(userDto.accountNoExpired())
                .roles(roleEntityList)
                .build();
        return userMapper.userToDTO(userRepository.save(user));

    }

    @Override
    public UserEntity update(Long id, UserDTO userDto) {
        List<String> rolesRequest = userDto.roleRequest().roleListName();
        Set<RoleEntity> roleEntityList = new HashSet<>(roleRepository.findRoleEntitiesByNameIn(rolesRequest));
        UserEntity userEdit = getById(id);
        userEdit.setEmail(userDto.email());
        userEdit.setPassword(passwordEncoder.encode(userDto.password()));
        userEdit.setRoles(roleEntityList);
        userEdit.setEnabled(userDto.isEnabled());
        userEdit.setCredentialNoExpired(userDto.credentialNoExpired());
        userEdit.setAccountNoExpired(userDto.accountNoExpired());
        userEdit.setAccountNoLocked(userDto.accountNoLocked());
        return userRepository.save(userEdit);
    }

    @Override
    public boolean deleteById(Long id)  {
        boolean exist = userRepository.existsById(id);
        if(exist){
            UserEntity deleteUser = getById(id);
            deleteUser.setAccountNoLocked(false);
            deleteUser.setAccountNoExpired(false);
            deleteUser.setCredentialNoExpired(false);
            deleteUser.setEnabled(false);
            userRepository.save(deleteUser);
        }
        return exist;
    }
}
