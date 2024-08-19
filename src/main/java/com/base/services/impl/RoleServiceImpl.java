package com.base.services.impl;

import com.base.dtos.RoleDTO;
import com.base.entities.PermissionEntity;
import com.base.entities.RoleEntity;
import com.base.repositories.PermissionRepository;
import com.base.repositories.RoleRepository;
import com.base.services.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        log.info("Iniciando servicio: " + this.getClass().getName());
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<RoleEntity> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity getById(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Rol no encontrado"));
    }

    @Override
    public RoleEntity save(RoleDTO roleDTO) {
        List<String> permissionRequest = roleDTO.permissionRequest().permissionListName();
        Set<PermissionEntity> permissionEntitiesList = new HashSet<>(permissionRepository.findPermissionEntitiesByNameIn(permissionRequest));
        RoleEntity newRol = RoleEntity.builder()
                .name(roleDTO.name())
                .permissionList(permissionEntitiesList)
                .build();
        return roleRepository.save(newRol);
    }

    @Override
    public RoleEntity update(Long id, RoleDTO roleDTO) {
        List<String> permissionRequest = roleDTO.permissionRequest().permissionListName();
        Set<PermissionEntity> permissionEntitiesList = new HashSet<>(permissionRepository.findPermissionEntitiesByNameIn(permissionRequest));
        RoleEntity editRol = getById(id);
        editRol.setName(roleDTO.name());
        editRol.setPermissionList(permissionEntitiesList);
        return roleRepository.save(editRol);
    }

}
