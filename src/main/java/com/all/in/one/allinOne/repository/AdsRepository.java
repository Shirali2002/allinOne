package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Ads;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Long> {

    List<Ads> findByOrderByTtlDesc(Pageable pageable);

}
