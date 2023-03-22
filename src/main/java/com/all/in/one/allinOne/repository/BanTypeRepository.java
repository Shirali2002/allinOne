package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.BanType;
import com.all.in.one.allinOne.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanTypeRepository extends JpaRepository<BanType, Integer> {

    BanType findByBanTypeCode(Integer code);

}
