package ru.ttv.newsportal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.Company;

import java.util.List;
import java.util.Optional;

/**
 * @author Timofey Teplykh
 */
public interface AdvService {

    Optional<Adv> get(Long id);

    @PreAuthorize("hasAuthority('user') or hasAuthority('admin')")
    void save(Adv adv);
    @PreAuthorize("hasAuthority('admin')")
    void delete(Adv adv);
    @PreAuthorize("hasAuthority('admin')")
    void update(Adv adv);
    Company getCompanyByAdv(Adv adv);
    Page<Adv> getAll(Pageable pageable);
    List<Adv> getAll();
    public Page<Adv> getByCategoryId(Long id, Pageable pageable);
    public List<Adv> getByCategoryId(Long id);


}
