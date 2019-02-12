package ru.ttv.newsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.repository.CompanyRepository;

/**
 * @author Timofey Teplykh
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public Company get(Long id) {
        return companyRepository.getOne(id);
    }
}
