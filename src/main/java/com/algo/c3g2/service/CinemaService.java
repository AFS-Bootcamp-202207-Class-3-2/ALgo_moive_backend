package com.algo.c3g2.service;

import cn.hutool.core.util.StrUtil;
import com.algo.c3g2.controller.dto.CinemaSearchRequest;
import com.algo.c3g2.entity.Cinema;
import com.algo.c3g2.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public Page<Cinema> getCinemas(CinemaSearchRequest cinemaSearch) {
        Pageable pageable = PageRequest.of(cinemaSearch.getPage(), cinemaSearch.getPageSize());
        Page<Cinema> cinemas;
        String search = cinemaSearch.getSearch();
        if (StrUtil.isNotBlank(search)) {
            cinemas = cinemaRepository.findAllByCinemaNameContaining(search, pageable);
        }else {
            cinemas = cinemaRepository.findAll(pageable);
        }
        return cinemas;
    }

    public List<Cinema> getCinemasByMovieId(String movieId) {
        return cinemaRepository.findCinemasByMovieId(movieId);
    }

    public Cinema findCinemaByCinemaId(String cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow(null);
    }
}
