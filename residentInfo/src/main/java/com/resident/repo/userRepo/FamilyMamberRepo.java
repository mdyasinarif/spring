package com.resident.repo.userRepo;



import com.resident.entity.user.FamilyMamber;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMamberRepo extends JpaRepository<FamilyMamber,Long> {

}
