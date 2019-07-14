package com.imamia.repo;

import com.imamia.entity.News;
import com.imamia.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video,Long> {
    News findByTitle(String title);
}
