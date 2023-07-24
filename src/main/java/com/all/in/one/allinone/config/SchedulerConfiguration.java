package com.all.in.one.allinone.config;

import com.all.in.one.allinone.parser.TurboAzParser;
import com.all.in.one.allinone.scheduler.ParseTurboAzScheduler;
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