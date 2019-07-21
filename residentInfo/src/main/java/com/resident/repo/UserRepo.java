package com.resident.repo;



import com.resident.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmailOrAgeAndEducation(String email, int age, String education);
}
