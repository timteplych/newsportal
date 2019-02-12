package ru.ttv.newsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.repository.AdvRepository;
import ru.ttv.newsportal.repository.CompanyRepository;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Service
public class AdvServiceImpl implements AdvService {

    @Autowired
    private AdvRepository advRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Adv> getAll() {
        return advRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Adv get(Long id) {
        return advRepository.getAdvById(id);
    }

    @Override
    @Transactional
    public void save(Adv adv) {
        advRepository.save(adv);
    }

    @Override
    @Transactional
    public void delete(Adv adv) {
        advRepository.delete(adv);
    }

    @Override
    public void update(Adv adv) {
        advRepository.save(adv);
    }

    @Override
    @Transactional
    public List<Adv> getByCategory(AdvCategory advCategory) {
        return advRepository.getAdvByCategory(advCategory);
    }

    @Override
    @Transactional
    public Company getCompanyByAdv(Adv adv) {
        return companyRepository.getCompanyById(adv.getCompany().getId());
    }
}
