package com.base.dtos;



import java.util.List;


public record AuthCreateRoleRequest(
        List<String> roleListName) {
}
