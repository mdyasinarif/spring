package com.imamia.repo;

import com.imamia.entity.Audio;
import com.imamia.entity.Event;
import com.imamia.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Long> {
    News findByTitle(String title);
}
