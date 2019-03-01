package ru.ttv.newsportal.service;

import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
public interface AdvCategoryService {

    AdvCategory get(Long id);
    List<AdvCategory> getAll();
    void save(AdvCategory advCategory);
    void remove(AdvCategory advCategory);

}
