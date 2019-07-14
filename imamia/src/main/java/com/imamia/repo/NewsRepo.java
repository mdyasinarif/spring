package com.imamia.repo;

import com.imamia.entity.News;
import com.imamia.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News,Long> {
    News findByTitle(String  title);
}
