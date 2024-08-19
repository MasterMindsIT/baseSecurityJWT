package com.base.dtos;

import java.util.List;

public record PermissionRequest(
        List<String> permissionListName
) {
}
