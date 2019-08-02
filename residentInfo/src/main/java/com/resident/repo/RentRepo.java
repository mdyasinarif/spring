package com.resident.repo;



import com.resident.entity.buliding.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepo extends JpaRepository<Rent,Long> {
    Rent findByRentType(String name);
}
