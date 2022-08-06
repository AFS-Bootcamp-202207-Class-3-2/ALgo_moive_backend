package com.algo.c3g2.repository;

import com.algo.c3g2.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
