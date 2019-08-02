package com.resident.repo;



import com.resident.entity.admin.User;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,Long> {
    Tenant findByContractNo(String contractNO);
    List<Tenant> findAllByUser(User user);
    Tenant findByUser(User user);

}
