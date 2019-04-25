package org.academiadecodigo.tropadelete.persistance.dao.jpa;

import org.academiadecodigo.tropadelete.persistance.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericJpaDao<T> implements Dao<T> {

    protected Class<T> modelClass;

    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelClass);
        Root<T> root = criteriaQuery.from(modelClass);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {

        return em.find(modelClass, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {

        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {

        em.remove(em.find(modelClass, id));
    }


}
