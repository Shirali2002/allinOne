package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.GearBoxType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearBoxTypeRepository extends JpaRepository<GearBoxType, Integer> {

    GearBoxType findByGearBoxCode(Integer code);

}
