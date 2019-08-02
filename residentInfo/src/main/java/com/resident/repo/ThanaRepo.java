package com.resident.repo;



import com.resident.entity.address.Thana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanaRepo extends JpaRepository<Thana,Long> {
  Thana findByName(String name);
}
