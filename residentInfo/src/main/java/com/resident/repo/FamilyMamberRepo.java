package com.resident.repo;



import com.resident.entity.user.FamilyMamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMamberRepo extends JpaRepository<FamilyMamber,Long> {
    FamilyMamber findByName(String name);
}
