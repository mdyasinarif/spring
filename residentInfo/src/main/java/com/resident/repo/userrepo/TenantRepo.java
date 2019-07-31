package com.resident.repo.userrepo;



import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,Long> {
    Tenant findByContractNo(String contractNO);
}
