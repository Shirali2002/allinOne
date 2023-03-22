package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findByCityCode(Integer code);

}
