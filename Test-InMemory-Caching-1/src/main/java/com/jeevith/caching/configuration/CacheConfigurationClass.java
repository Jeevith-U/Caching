package com.jeevith.caching.configuration;

import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfigurationClass {

    @Bean
    CacheManager cacheManager() {
	    SimpleCacheManager cacheManager = new SimpleCacheManager();
	    ConcurrentMapCache studentCache = new ConcurrentMapCache("student");
	    cacheManager.setCaches(List.of(studentCache));
	    return cacheManager;
	}
}
