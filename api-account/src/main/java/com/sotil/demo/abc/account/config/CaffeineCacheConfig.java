package com.sotil.demo.abc.account.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Log4j2
@Configuration
@EnableCaching
public class CaffeineCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("accountsCache","accountByIdCache");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(100)  // Max 100 entries
                .expireAfterWrite(1, TimeUnit.MINUTES)  // Expire after 1 minutes
                .recordStats());  // Enable cache statistics
        log.info("::::accountsCache::::, {}", Date::new);
        return cacheManager;
    }

}
