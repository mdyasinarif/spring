package com.resident.repo;


import com.resident.entity.admin.User;
import com.resident.entity.user.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceRepo extends JpaRepository<Police,Long> {
        Police findByContractNo(String contractNo);
        List<Police> findAllByUser(User user);
        Police findByUser(User user);
}
