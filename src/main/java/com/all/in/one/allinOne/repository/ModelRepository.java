package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
