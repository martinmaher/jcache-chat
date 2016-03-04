package de.consol.chat.config;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Cache;
import javax.cache.CacheManager;
import java.io.Serializable;

/**
 * @author Martin Maher
 * @since 2.2.1
 */
@Configuration
public class UserCacheConfig implements Serializable {
    public static final String USER_CACHE = "user";

    @Bean(name = "userCache")
    public Cache<Long, String> getUserCache(JCacheCacheManager cacheManager) {
        CacheManager cm = cacheManager.getCacheManager();
        return cm.getCache(USER_CACHE, Long.class, String.class);
    }
}
