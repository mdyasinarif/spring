package com.springHibernet.springHibernet.repo;

import com.springHibernet.springHibernet.entity.Department;
import com.springHibernet.springHibernet.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
