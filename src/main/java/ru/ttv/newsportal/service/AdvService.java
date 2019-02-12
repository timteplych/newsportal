package ru.ttv.newsportal.service;

import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.model.Company;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
public interface AdvService {

    List<Adv> getAll();
    Adv get(Long id);
    void save(Adv adv);
    void delete(Adv adv);
    void update(Adv adv);
    List<Adv> getByCategory(AdvCategory advCategory);
    Company getCompanyByAdv(Adv adv);

}
