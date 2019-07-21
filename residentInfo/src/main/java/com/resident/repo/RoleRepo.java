package com.resident.repo;


import com.resident.entity.admin.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
