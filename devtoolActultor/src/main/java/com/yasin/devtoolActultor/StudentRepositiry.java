package com.yasin.devtoolActultor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositiry extends JpaRepository<Student, Long> {
}
