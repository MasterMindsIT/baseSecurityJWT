package com.base.services.impl;

import com.base.entities.PermissionEntity;
import com.base.repositories.PermissionRepository;
import com.base.services.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class PermissionServiceImpl implements IPermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        log.info("Iniciando servicio: " + this.getClass().getName());
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<PermissionEntity> gelAll() {
        return permissionRepository.findAll();
    }
}
