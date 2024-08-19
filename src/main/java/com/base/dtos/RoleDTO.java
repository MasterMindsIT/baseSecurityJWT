package com.base.dtos;

import jakarta.validation.constraints.NotBlank;

public record RoleDTO (
        @NotBlank String name,
        PermissionRequest permissionRequest) {
}
