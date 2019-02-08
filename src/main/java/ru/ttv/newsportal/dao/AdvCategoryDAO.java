package ru.ttv.newsportal.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.AdvCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Component
@Transactional
public class AdvCategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(AdvCategory advCategory){
        entityManager.persist(advCategory);
    }

    public void merge(AdvCategory advCategory){
        entityManager.merge(advCategory);
    }

    public AdvCategory find(String id){
        return entityManager.find(AdvCategory.class,id);
    }

    public void remove(String id){
        entityManager.remove(find(id));
    }

    public List<AdvCategory> findAll(){
        return entityManager.createQuery("SELECT e FROM AdvCategory e", AdvCategory.class).getResultList();
    }

    public void removeAll(){
        entityManager.createQuery("DELETE FROM AdvCategory e").executeUpdate();
    }

}
