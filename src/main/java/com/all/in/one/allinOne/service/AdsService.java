package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.AdsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsService {

    private final AdsRepository adsRepository;

    public List<Ads> getAds(Integer from, Integer to) {
        Pageable pageable = PageRequest.of(from, to, Sort.by("ttl").descending());
        return adsRepository.findByOrderByTtlDesc(pageable);
    }

}
