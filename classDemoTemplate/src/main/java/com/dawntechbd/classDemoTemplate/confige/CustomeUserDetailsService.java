package com.dawntechbd.classDemoTemplate.confige;

import com.dawntechbd.classDemoTemplate.entity.User;
import com.dawntechbd.classDemoTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not Found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
