package com.resident.repo.builldingRepo;



import com.resident.entity.buliding.Buillding;
import com.resident.entity.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuilldingRepo extends JpaRepository<Buillding,Long> {

}
