package com.resident.repo.userRepo;


import com.resident.entity.user.Police;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoilceRepo extends JpaRepository<Police,Long> {
        Police findByContractNo(String contractNo);
}
