package com.resident.repo;



import com.resident.entity.buliding.Flat;
import com.resident.entity.user.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {
 Flat findByName(String name);
 Iterable<Flat> findAllByStatus(boolean status);
}
