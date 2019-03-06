package ru.ttv.newsportal.service;

import ru.ttv.newsportal.model.Company;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
public interface CompanyService {

    Company get(Long id);

    List<Company> getAll();

    void save(Company company);

    void remove(Company company);

    Company getByLogin(String login);

}
