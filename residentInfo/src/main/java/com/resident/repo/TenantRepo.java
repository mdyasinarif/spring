package com.resident.repo;



import com.resident.entity.address.Thana;
import com.resident.entity.admin.User;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,Long> {

    List<Tenant> findAllByUser(User user);
    Tenant findByUser(User user);
    Tenant findByContractNo(String  contractNO);
    Iterable<Tenant> findAllByThana(Thana thana);

}
