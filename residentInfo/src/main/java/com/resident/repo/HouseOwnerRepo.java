package com.resident.repo;



import com.resident.entity.address.Thana;
import com.resident.entity.admin.User;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseOwnerRepo extends JpaRepository<HouseOwner,Long> {
    HouseOwner findByContractNo(String contractNO);
    List<HouseOwner> findAllByUser(User user);
    HouseOwner findByUser(User user);
}
