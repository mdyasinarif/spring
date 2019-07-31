package com.resident.repo.builldingrepo;



import com.resident.entity.buliding.Builliding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuillidingRepo extends JpaRepository<Builliding,Long> {
        Builliding findByName(String name);
        Builliding findByAdress(String address);
}
