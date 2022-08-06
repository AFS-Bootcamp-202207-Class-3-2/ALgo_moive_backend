package com.algo.c3g2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Company {

    @Id
    private Integer id;
    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Company() {
    }

    public Company(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }
}
