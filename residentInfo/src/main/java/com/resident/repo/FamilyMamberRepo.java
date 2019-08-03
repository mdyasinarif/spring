package com.resident.repo;



import com.resident.entity.admin.User;
import com.resident.entity.user.FamilyMamber;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMamberRepo extends JpaRepository<FamilyMamber,Long> {
    FamilyMamber findByName(String name);
//    List<FamilyMamber> findAllByUser(User user);
    List<FamilyMamber> findAllByHouseOwner(HouseOwner houseOwner);

}

