package com.resident.repo;

import com.resident.entity.buliding.Flat;
import com.resident.entity.buliding.RentCollection;
import com.resident.entity.user.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentCollectionRepo extends JpaRepository<RentCollection, Long> {
//     RentCollection findAllBy(long id);
   Iterable <RentCollection> findAllByFlat(Flat flat);
   Iterable <RentCollection> findAllByTenant(Tenant tenant);

}
