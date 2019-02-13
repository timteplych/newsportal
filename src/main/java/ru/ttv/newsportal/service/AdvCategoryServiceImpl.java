package ru.ttv.newsportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.repository.AdvCategoryRepository;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Service
public class AdvCategoryServiceImpl implements AdvCategoryService {

    @Autowired
    private AdvCategoryRepository advCategoryRepository;

    @Override
    @Transactional(readOnly = true)
    public AdvCategory get(Long id) {
        return advCategoryRepository.getAdvCategoryById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdvCategory> getAll() {
        return advCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(AdvCategory advCategory) {
        advCategoryRepository.save(advCategory);
    }

    @Override
    @Transactional
    public void remove(AdvCategory advCategory) {
        advCategoryRepository.delete(advCategory);
    }
}
