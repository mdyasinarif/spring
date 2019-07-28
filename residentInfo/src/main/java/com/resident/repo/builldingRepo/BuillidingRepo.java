package com.resident.repo.builldingRepo;



import com.resident.entity.buliding.Builliding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuillidingRepo extends JpaRepository<Builliding,Long> {
        Builliding findByName(String name);
}
