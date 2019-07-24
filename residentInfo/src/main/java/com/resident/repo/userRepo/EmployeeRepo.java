package com.resident.repo.userRepo;



import com.resident.entity.user.Employee;
import com.resident.entity.user.FamilyMamber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
