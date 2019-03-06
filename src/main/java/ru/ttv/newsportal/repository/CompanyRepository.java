package ru.ttv.newsportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ttv.newsportal.model.Company;

/**
 * @author Timofey Teplykh
 */
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company getCompanyById(Long id);

    Company findByLogin(String login);
}
