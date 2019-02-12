package ru.ttv.newsportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Repository
public interface AdvRepository extends JpaRepository<Adv,Long> {
    List<Adv> getAdvByCategory(AdvCategory category);
    Adv getAdvById(Long id);
}
