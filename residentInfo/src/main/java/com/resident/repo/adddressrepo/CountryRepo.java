package com.resident.repo.adddressrepo;



import com.resident.entity.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
    Country findByName(String name);
}
