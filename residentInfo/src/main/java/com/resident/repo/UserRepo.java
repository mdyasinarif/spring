package com.resident.repo;



import com.resident.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserNameOrPhone(String userName, String phone);

    User findByUserName(String userName);



}
