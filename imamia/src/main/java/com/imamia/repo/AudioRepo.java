package com.imamia.repo;

import com.imamia.entity.Audio;
import com.imamia.entity.News;
import com.imamia.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepo extends JpaRepository<Audio,Long> {
    News findByTitle(String title);
}
