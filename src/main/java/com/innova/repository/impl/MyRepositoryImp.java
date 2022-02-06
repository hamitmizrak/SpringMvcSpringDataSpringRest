package com.innova.repository.impl;

import com.innova.entity.ComputerEntity;
import com.innova.repository.IMyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MyRepositoryImp implements IMyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ComputerEntity> findComputerPriceMin(double minPrice) {
        //SELECT * FROM innova_patika_project_1.computer where computer_price>66;
        String jpql="select c from ComputerEntity c where c.computerPrice >=:key";
        TypedQuery<ComputerEntity> typedQuery= entityManager.createQuery(jpql,ComputerEntity.class);
        typedQuery.setParameter("key",minPrice);
        return typedQuery.getResultList();
    }
}
