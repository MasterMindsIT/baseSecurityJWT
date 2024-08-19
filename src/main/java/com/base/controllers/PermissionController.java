package com.base.controllers;

import com.base.entities.PermissionEntity;
import com.base.entities.RoleEntity;
import com.base.services.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@PreAuthorize("denyAll()")
@Slf4j
public class PermissionController   {
    private final IPermissionService permissionService;

    public PermissionController(IPermissionService permissionService) {
        log.info("Iniciando restcontroller: " + this.getClass().getName());
        this.permissionService = permissionService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ALL_PERMISSION')")
    public List<PermissionEntity> gelAll() {
        return permissionService.gelAll();
    }
}
