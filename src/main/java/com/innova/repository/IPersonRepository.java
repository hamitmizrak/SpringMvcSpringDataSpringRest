package com.innova.repository;

import com.innova.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {
}
