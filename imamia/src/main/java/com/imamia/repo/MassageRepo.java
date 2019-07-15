package com.imamia.repo;

import com.imamia.entity.Audio;
import com.imamia.entity.Massage;
import com.imamia.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassageRepo extends JpaRepository<Massage,Long> {
    News findByTitle(String title);
}
