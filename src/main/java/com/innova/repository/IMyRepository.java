package com.innova.repository;

import com.innova.entity.ComputerEntity;

import java.util.List;

public interface IMyRepository {

    public List<ComputerEntity> findComputerPriceMin(double minPrice );
}
