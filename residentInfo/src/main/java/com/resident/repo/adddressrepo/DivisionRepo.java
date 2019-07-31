package com.resident.repo.adddressrepo;



import com.resident.entity.address.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepo extends JpaRepository<Division,Long> {
    Division findByName(String name);
}
