package com.resident.repo.adddressrepo;



import com.resident.entity.address.CityCorporation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityCorporationRepo extends JpaRepository<CityCorporation,Long> {
        CityCorporation findByName(String name);
}
