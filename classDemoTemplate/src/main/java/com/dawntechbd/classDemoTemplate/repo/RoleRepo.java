package com.dawntechbd.classDemoTemplate.repo;

import com.dawntechbd.classDemoTemplate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRolename(String rolename);

}
