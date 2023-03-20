package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Brand;
import com.all.in.one.allinOne.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
