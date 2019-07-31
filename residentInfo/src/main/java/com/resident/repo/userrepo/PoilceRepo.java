package com.resident.repo.userrepo;


import com.resident.entity.user.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoilceRepo extends JpaRepository<Police,Long> {
        Police findByContractNo(String contractNo);
}
