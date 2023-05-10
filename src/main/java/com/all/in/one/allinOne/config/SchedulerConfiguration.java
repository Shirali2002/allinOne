package com.all.in.one.allinOne.config;

import com.all.in.one.allinOne.parser.TurboAzParser;
import com.all.in.one.allinOne.scheduler.ParseTurboAzScheduler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {

    @Bean
    @ConditionalOnProperty(value = "parse.turbo-az.enable-schedule", havingValue = "true")
    public ParseTurboAzScheduler parseTurboAzScheduler(TurboAzParser turboAzParser) {
        return new ParseTurboAzScheduler(turboAzParser);
    }

}