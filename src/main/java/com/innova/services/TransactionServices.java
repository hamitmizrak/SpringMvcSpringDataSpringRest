package com.innova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;

//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TransactionServices {

//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Autowired
//    private EntityManager entityManager;


    public void ilkelTransaction(){
//        transactionManager.commit(transactionManager.getTransaction(new DefaultTransactionDefinition()));
//        try {
//
//        }catch (Exception e){
//            transactionManager.rollback(transactionManager.getTransaction(new DefaultTransactionDefinition()));
//        }
    }
}
