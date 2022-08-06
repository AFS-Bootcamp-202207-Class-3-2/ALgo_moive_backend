package com.algo.c3g2.controller;

import com.algo.c3g2.entity.Company;
import com.algo.c3g2.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/hello/{id}")
    public Company getHello(@PathVariable Integer id){
        Company company = companyRepository.findById(id).orElse(null);
        return company;
    }
}
