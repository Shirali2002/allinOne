package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Brand;
import com.all.in.one.allinOne.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByCode(Integer code);

}
