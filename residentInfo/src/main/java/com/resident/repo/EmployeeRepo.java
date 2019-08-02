package com.resident.repo;



import com.resident.entity.admin.User;
import com.resident.entity.user.Employee;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByName(String name);
    List<Employee> findAllByAndHouseOwner(HouseOwner houseOwner);
}
