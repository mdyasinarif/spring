package com.resident.repo;



import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {
 Flat findByName(String name);
 List <Flat> findAllByBuildingAndStatus(Building building,boolean status);
 Iterable<Flat> findAllByStatus(boolean status);
 Iterable<Flat> findAllByBuilding(Building building);
 Iterable<Flat> findAllByHouseOwner(HouseOwner houseOwner);


}
