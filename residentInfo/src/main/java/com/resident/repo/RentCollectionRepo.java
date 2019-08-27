package com.resident.repo;

import com.resident.entity.buliding.RentCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentCollectionRepo extends JpaRepository<RentCollection , Long> {


}
