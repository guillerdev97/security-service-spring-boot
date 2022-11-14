package com.guillerdev97.userservice.service;

import com.guillerdev97.userservice.domain.AppRole;
import com.guillerdev97.userservice.domain.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);

    AppRole saveRole(AppRole role);

    void addAppRoleToAppUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
