package com.all.in.one.allinone.config;

import com.all.in.one.allinone.parser.TurboAzParser;
import com.all.in.one.allinone.scheduler.ParseTurboAzScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

@Configuration
@EnableScheduling
@ConditionalOnProperty(value = "project.enable-parse", havingValue = "true")
@Slf4j
public class SchedulerConfiguration {

    @Bean
    @ConditionalOnExpression("${project.turbo-az.enable-parse} == true and ${project.enable-cache} == true")
    public ParseTurboAzScheduler parseTurboAzSchedulerWithCache(TurboAzParser turboAzParser,
                                                       @Qualifier("cacheManager") CacheManager cacheManager) {
        return new ParseTurboAzScheduler(turboAzParser, cacheManager);
    }

    @Bean
    @ConditionalOnExpression("${project.turbo-az.enable-parse} == true and ${project.enable-cache} == false")
    public ParseTurboAzScheduler parseTurboAzScheduler(TurboAzParser turboAzParser) {
        return new ParseTurboAzScheduler(turboAzParser);
    }

}