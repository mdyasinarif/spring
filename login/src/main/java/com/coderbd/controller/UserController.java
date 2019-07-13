package com.coderbd.controller;

import com.coderbd.entity.Role;
import com.coderbd.entity.User;
import com.coderbd.repo.RoleRepo;
import com.coderbd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(3L));
        User user = new User("Mr Suvo", "suvo", passwordEncoder.encode("1234"), "suvo@gmail.com", true, roles);
        repo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2L));
        User user2 = new User("Mr Rony", "rony", passwordEncoder.encode("1234"), "rony@gmail.com", true, roles2);
        repo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(3L));
        User user3 = new User("Mr Motin", "motin", passwordEncoder.encode("1234"), "motin@gmail.com", true, roles3);
        repo.save(user3);

        Set<Role> roles4 = new HashSet<>();
        roles4.add(new Role(1L));
        roles4.add(new Role(2L));
        roles4.add(new Role(3L));
        User user4 = new User("MR Yasin", "yasin", passwordEncoder.encode("1234"), "yasin@gmail.com", true, roles4);
        repo.save(user4);
        return "success";
    }
}
