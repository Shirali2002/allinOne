package com.all.in.one.allinone.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Objects;

@Configuration
@EnableCaching
@ConditionalOnProperty(value = "project.enable-cache", havingValue = "true")
@Slf4j
public class RedisCacheConfig {

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer(getClass().getClassLoader());

        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(30))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("dashboardFieldsCache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(365)))
                .withCacheConfiguration("dashboardModelsCache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(365)))
                .withCacheConfiguration("adsPagesCache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)))
                .withCacheConfiguration("adsFilteredPagesCache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)));
    }

    @Bean
    public CommandLineRunner clear(@Qualifier("cacheManager") CacheManager cacheManager) {
        return (args) -> {
            clearAllCache(cacheManager);
        };
    }

    private void clearAllCache(CacheManager cacheManager) {
        if (Objects.isNull(cacheManager)) return;

        for (String cacheName : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(cacheName);

            if (Objects.isNull(cache)) return;

            cache.clear();
            log.info("{} cleared.", cacheName);
        }

    }

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }

}
