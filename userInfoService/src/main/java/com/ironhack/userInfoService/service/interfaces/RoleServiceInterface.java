package com.ironhack.userInfoService.service.interfaces;

import com.ironhack.userInfoService.model.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}
