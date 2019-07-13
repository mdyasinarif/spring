package com.springHibernet.springHibernet.repo;

import com.springHibernet.springHibernet.entity.Department;
import com.springHibernet.springHibernet.entity.Student;
import com.springHibernet.springHibernet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByFileName(String filename);
}
