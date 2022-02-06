package com.innova.repository;

import com.innova.entity.ComputerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepository extends CrudRepository<ComputerEntity,Long> {

    //Register MVC thymeleaf, Entity register, Database ekleyeğiz
}
