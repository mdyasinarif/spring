package com.resident.repo;



import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOwnerRepo extends JpaRepository<HouseOwner,Long> {
    HouseOwner findByContractNo(String contractNO);
}
