/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evidence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author J2EE-39
 */
@Repository
public interface UserRepo  extends JpaRepository<User, Long>{
    User findByUsernameOrEmailOrRoles(String username,String email,Role role);
}
