package com.all.in.one.allinOne.scheduler;

import com.all.in.one.allinOne.parser.TurboAzParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
public class ParseTurboAzScheduler {

    private final TurboAzParser turboAzParser;

    @Async
    @Scheduled(cron = "${parse.turbo-az.cron}")
    public void parseTurboAz() {
        log.info("parsing started");
        Integer page = 1;

        while (page > 0 && page < 20) {
            log.info("parsing page {}", page);
            page = turboAzParser.parse(page);
        }

        log.info("parse finished");

    }

}