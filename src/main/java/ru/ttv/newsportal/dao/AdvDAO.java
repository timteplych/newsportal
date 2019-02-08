package ru.ttv.newsportal.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.newsportal.model.Adv;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Component
@Transactional
public class AdvDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Adv adv){
        entityManager.persist(adv);
    }

    public void merge(Adv adv){
        entityManager.merge(adv);
    }

    public Adv find(String id){
        return entityManager.find(Adv.class,id);
    }

    public void remove(String id){
        entityManager.remove(find(id));
    }

    public List<Adv> findAll(){
        return entityManager.createQuery("SELECT e FROM Adv e", Adv.class).getResultList();
    }

    public void removeAll(){
        entityManager.createQuery("DELETE FROM Adv e").executeUpdate();
    }

}
