package com.imamia.repo;

import com.imamia.entity.Audio;
import com.imamia.entity.Ebook;
import com.imamia.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepo extends JpaRepository<Ebook,Long> {
    News findByTitle(String title);
}
