package com.resident.repo.userRepo;



import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepo extends JpaRepository<Tenant,Long> {
    Tenant findByContractNo(String contractNO);
}
