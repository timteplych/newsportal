package ru.ttv.newsportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ttv.newsportal.model.AdvCategory;

/**
 * @author Timofey Teplykh
 */

@Repository
public interface AdvCategoryRepository extends JpaRepository<AdvCategory,Long> {

    AdvCategory getAdvCategoryById(Long id);

}
