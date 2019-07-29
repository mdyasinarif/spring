package com.resident.repo.builldingRepo;



import com.resident.entity.buliding.Flat;
import com.resident.entity.buliding.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent,Long> {
    Rent findByRentType(String name);
}
