package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String> {
    Page<Cinema> findAllByCinemaNameContaining(String search, Pageable pageable);
}
