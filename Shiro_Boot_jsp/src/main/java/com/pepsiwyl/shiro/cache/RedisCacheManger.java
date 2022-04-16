package com.pepsiwyl.shiro.cache;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-04-14 8:23
 */

@Slf4j

@Component("redisCacheManger")
// redis 充当Shiro中缓存管理器
public class RedisCacheManger implements CacheManager {

    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        return new RedisCache<K, V>(cacheName);
    }

}
