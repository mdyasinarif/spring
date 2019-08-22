package com.resident.repo;



import com.resident.entity.buliding.Builliding;
import com.resident.entity.buliding.Flat;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {
 Flat findByName(String name);
 List <Flat> findAllByBuillidingAndStatus(Builliding builliding,boolean status);
 Iterable<Flat> findAllByStatus(boolean status);

}
