package com.springHibernet.springHibernet.repo;

import com.springHibernet.springHibernet.entity.Department;
import com.springHibernet.springHibernet.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByDepartmentOrderByName(Department department);

    Iterable<Student> findAllByDepartmentAndGender(Department department, String gender);

    long countAllByDepartmentAndGender(Department department, String gender);

    Iterable<Student> findAllByAgeGreaterThanEqual(int age);


}
