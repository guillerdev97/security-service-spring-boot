package com.guillerdev97.userservice.service;

import com.guillerdev97.userservice.domain.AppRole;
import com.guillerdev97.userservice.domain.AppUser;
import com.guillerdev97.userservice.repository.RoleRepository;
import com.guillerdev97.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} into the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Saving new role {} into the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addAppRoleToAppUser(String username, String roleName) {
        log.info("Adding role {} to user {}", username, roleName);
        AppUser user = userRepository.findByUsername(username);
        AppRole role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
