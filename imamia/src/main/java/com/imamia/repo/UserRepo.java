package com.imamia.repo;


import com.imamia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmailOrAgeAndEducation(String email, int age, String education);
}
