package ru.ttv.newsportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Repository
public interface AdvRepository extends PagingAndSortingRepository<Adv,Long> {
    Adv getAdvById(Long id);

    @Query("select  a FROM Adv a WHERE a.category.id=:id")
    public Page<Adv> findByCategoryId(@Param ("id") Long id, Pageable pageable);

    @Query("select  a FROM Adv a WHERE a.category.id=:id")
    public List<Adv> findByCategoryId(@Param ("id") Long id);

}
