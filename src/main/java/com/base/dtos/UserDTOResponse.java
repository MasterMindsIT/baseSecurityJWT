package com.base.dtos;

import com.base.entities.RoleEntity;
import java.util.Set;

public record UserDTOResponse(Long id,
        String username,
        String email,
        String password,
        boolean isEnabled,
        boolean accountNoExpired,
        boolean accountNoLocked,
        boolean credentialNoExpired,
        Set<RoleEntity> roles) {
}
