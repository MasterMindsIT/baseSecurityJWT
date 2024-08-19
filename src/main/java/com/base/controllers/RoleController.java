package com.base.controllers;

import com.base.dtos.PermissionRequest;
import com.base.dtos.RoleDTO;
import com.base.entities.RoleEntity;
import com.base.services.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/roles")
@PreAuthorize("denyAll()")
@Slf4j
public class RoleController  {
    private final IRoleService roleService;

    public RoleController(IRoleService roleService)  {
        log.info("Iniciando restcontroller: " + this.getClass().getName());
        this.roleService = roleService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ALL_ROLE')")
    public List<RoleEntity> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ_ROLE')")
    public RoleEntity getById(@PathVariable("id") Long id) {
        return roleService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    public RoleEntity save(@RequestBody RoleDTO rol) {
        log.info("Controller :"+rol);
        return roleService.save(rol);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    public RoleEntity update(@PathVariable("id") Long id,@RequestBody  RoleDTO rol) {
        return roleService.update(id,rol);
    }

}
