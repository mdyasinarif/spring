package com.resident.repo;



import com.resident.entity.address.Thana;
import com.resident.entity.admin.User;
import com.resident.entity.buliding.Flat;
import com.resident.entity.buliding.Rent;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepo extends JpaRepository<Rent,Long> {
    Rent findByRentType(String name);
    Iterable<Rent> findAllByThana(Thana thana);
    Iterable<Rent> findAllByHouseOwner(HouseOwner houseOwner);

}
