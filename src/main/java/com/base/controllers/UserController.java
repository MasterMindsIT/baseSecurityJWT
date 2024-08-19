package com.base.controllers;

import com.base.dtos.UserDTO;
import com.base.dtos.UserDTOResponse;
import com.base.entities.UserEntity;
import com.base.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
@PreAuthorize("denyAll()")
@Slf4j
public class UserController  {
    private final IUserService userService;

    public UserController(IUserService userService) {
        log.info("Iniciando restcontroller: " + this.getClass().getName());
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ALL_USER')")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ_USER')")
    public UserEntity getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_USER')")
    public UserDTOResponse save(@RequestBody UserDTO user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public UserEntity update(@PathVariable("id") Long id,@RequestBody UserDTO user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    public boolean deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
