package com.resident.repo;



import com.resident.entity.buliding.Builliding;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuillidingRepo extends JpaRepository<Builliding,Long> {
        Builliding findByName(String name);
        Builliding findByAdress(String address);
         List<Builliding> findAllByHouseOwner(HouseOwner houseOwner);
}
