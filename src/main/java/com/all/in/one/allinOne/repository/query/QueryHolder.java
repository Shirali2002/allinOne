package com.all.in.one.allinOne.repository.query;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Setter
@Configuration
@ConfigurationProperties(prefix = "allinone")
@PropertySource(value = "classpath:/queries/query.xml")
public class QueryHolder {

    private Map<String, String> query;

    public String get(Queries key) {
        return query.get(key.key());
    }

}