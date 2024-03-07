package com.anand.MonolithicSpring.service;

import com.anand.MonolithicSpring.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company addCompany(Company company);

    Boolean deleteById(Long id);

    Company getById(Long id);

    Boolean updateById(Long id, Company company);
}
