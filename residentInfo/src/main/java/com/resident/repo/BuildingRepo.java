package com.resident.repo;


import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long> {
    Building findByName(String name);

    Building findByAddress(String address);

    List<Building> findAllByHouseOwner(HouseOwner houseOwner);
}
