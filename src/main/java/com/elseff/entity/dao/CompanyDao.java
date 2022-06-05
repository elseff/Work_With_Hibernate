package com.elseff.entity.dao;

import com.elseff.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {
    Optional<Company> getCompanyByName(String name);

    Optional<Company> getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company addCompany(Company company);

    void deleteCompany(Long id);
}
