package com.resident.repo.builldingRepo;



import com.resident.entity.buliding.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepo extends JpaRepository<Flat,Long> {
 Flat findByName(String name);
}
