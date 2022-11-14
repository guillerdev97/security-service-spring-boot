package com.guillerdev97.userservice.repository;

import com.guillerdev97.userservice.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
