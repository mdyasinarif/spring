package com.resident.repo;



import com.resident.entity.admin.User;
import com.resident.entity.user.Employee;
import com.resident.entity.user.FamilyMamber;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByName(String name);
    List<Employee> findAllByHouseOwner(HouseOwner houseOwner);
    List<Employee> findAllByTenant(Tenant tenant);
}
