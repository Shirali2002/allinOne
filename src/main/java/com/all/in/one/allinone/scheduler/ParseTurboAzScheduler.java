package com.all.in.one.allinone.scheduler;

import com.all.in.one.allinone.parser.turboAz.TurboAzAdsParser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class ParseTurboAzScheduler {

    private final TurboAzAdsParser turboAzAdsParser;
    private CacheManager cacheManager;

    @Async
    @Scheduled(cron = "${project.turbo-az.cron}")
    public void parseTurboAz() {
        log.info("parsing started");
        Integer page = 1;

        while (page > 0 && page < 20) {
            log.info("parsing page {}", page);
            page = turboAzAdsParser.parse(page);
        }
        log.info("parse finished");

        clearAdsPagesCache();
    }

    private void clearAdsPagesCache() {
        if (Objects.isNull(cacheManager)) return;

        clearCacheByName("adsPagesCache");
        clearCacheByName("adsFilteredPagesCache");
    }

    private void clearCacheByName(String name) {
        Cache cache = cacheManager.getCache(name);

        if (Objects.isNull(cache)) return;

        cache.clear();
        log.info("{} cleared.", cache.getName());
    }

}