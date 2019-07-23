package com.resident.repo;



import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseOwnerRepo extends JpaRepository<HouseOwner,Long> {

}
