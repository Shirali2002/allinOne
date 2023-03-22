package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findModelByBrand_BrandCode(Integer brandCode);

    Model findByModelCode(Integer code);

}
