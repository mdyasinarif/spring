package com.resident.repo.adddressRepo;



import com.resident.entity.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Long> {

}
