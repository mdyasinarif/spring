package com.resident.repo.adddressRepo;



import com.resident.entity.address.CityCorporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityCorporationRepo extends JpaRepository<CityCorporation,Long> {
        CityCorporation findByName(String name);
}
