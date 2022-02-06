package com.innova.repository;

import com.innova.entity.ComputerEntity;
import com.innova.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDelivedQueryRepository  extends JpaRepository<PersonEntity,Long> {

    List<PersonEntity> findByPersonNameStartingWith(String personName);
    List<PersonEntity> findByPersonNameEndsWith(String personName);

}
