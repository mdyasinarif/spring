package com.security.repo;

import com.security.entiy.Permission;
import com.security.entiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Long> {

}
