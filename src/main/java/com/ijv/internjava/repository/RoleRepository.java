package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.Role;
import com.ijv.internjava.model.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findRoleByName(RoleName name);
}
