package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourRepository extends JpaRepository<Colour, Integer> {

    Colour findByColourCode(Integer code);

}
