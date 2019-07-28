package com.resident.repo.adddressRepo;



import com.resident.entity.address.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepo extends JpaRepository<Division,Long> {
    Division findByName(String name);
}
