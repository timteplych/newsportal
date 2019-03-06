package ru.ttv.newsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.model.Role;
import ru.ttv.newsportal.repository.CompanyRepository;
import ru.ttv.newsportal.repository.RoleRepository;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String DEFAULT_ROLE_NAME = "user";

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Company get(Long id) {
        return companyRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Company company) {
        Role role = roleRepository.findByName(DEFAULT_ROLE_NAME);
        company.setRole(role);
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public void remove(Company company) {
        companyRepository.delete(company);
    }

    @Override
    @Transactional(readOnly = true)
    public Company getByLogin(String login) {
        Company company = companyRepository.findByLogin(login);
        return company;
    }
}
