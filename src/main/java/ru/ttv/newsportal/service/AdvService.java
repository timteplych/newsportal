package ru.ttv.newsportal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.Company;

import java.util.List;
import java.util.Optional;

/**
 * @author Timofey Teplykh
 */
public interface AdvService {

    Optional<Adv> get(Long id);
    void save(Adv adv);
    void delete(Adv adv);
    void update(Adv adv);
    Company getCompanyByAdv(Adv adv);
    Page<Adv> getAll(Pageable pageable);
    List<Adv> getAll();
    public Page<Adv> getByCategoryId(Long id, Pageable pageable);
    public List<Adv> getByCategoryId(Long id);

}
