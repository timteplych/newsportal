package ru.ttv.newsportal.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.repository.AdvRepository;
import ru.ttv.newsportal.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

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
    public Page<Adv> getAll(Pageable pageable) {
        Page<Adv> advs = advRepository.findAll(pageable);
        return advs;
    }

    @Override
    public List<Adv> getAll() {
        return Lists.newArrayList(advRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Adv> get(Long id) {
        return advRepository.findById(id);
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
    public Company getCompanyByAdv(Adv adv) {
        return companyRepository.getCompanyById(adv.getCompany().getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Adv> getByCategoryId(Long id, Pageable pageable) {
        Page<Adv> advs = advRepository.findByCategoryId(id, pageable);
        return advs;
    }

    @Override
    public List<Adv> getByCategoryId(Long id) {
        List<Adv> advList = advRepository.findByCategoryId(id);
        return advList;
    }
}
