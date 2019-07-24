package com.resident.repo.adminRepo;



import com.resident.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByPhone(String phone);
}
