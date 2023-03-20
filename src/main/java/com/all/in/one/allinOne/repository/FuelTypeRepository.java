package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Integer> {
}
