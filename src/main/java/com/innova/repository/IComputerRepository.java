package com.innova.repository;

import com.innova.entity.ComputerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IComputerRepository extends CrudRepository<ComputerEntity,Long>,IMyRepository {

    //1.YOL
    //Register MVC thymeleaf, Entity register, Database ekleyeğiz
    List<ComputerEntity>  findComputerEntitiesByComputerName(String computerName);

    //2.YOL
//    @Query("select c from ComputerEntity c where c.computerName=:computerName")
//    List<ComputerEntity> findComputerEntitiesByComputerName(@Param("computerName") String computerName);

}
