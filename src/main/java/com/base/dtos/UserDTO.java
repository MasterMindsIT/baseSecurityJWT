package com.base.dtos;

import jakarta.validation.Valid;
public record UserDTO(
        String username,
        String email,
        String password,
        boolean isEnabled,
        boolean accountNoExpired,
        boolean accountNoLocked,
        boolean credentialNoExpired,
        @Valid AuthCreateRoleRequest roleRequest) {
}
