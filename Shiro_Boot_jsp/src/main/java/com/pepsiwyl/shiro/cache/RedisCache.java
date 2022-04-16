package com.pepsiwyl.shiro.cache;

import com.pepsiwyl.utils.ApplicationContextUtils;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * @author by pepsi-wyl
 * @date 2022-04-14 8:37
 */

@Slf4j

// Redis 缓存实现
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RedisCache<K, V> implements Cache<K, V> {

    /**
     * cacheName
     */
    private String cacheName;

    /**
     * redisTemplate
     *
     * @return
     */
    private static RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = ApplicationContextUtils.getBean("redisTemplate", RedisTemplate.class);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Override
    public V get(K k) throws CacheException {
        log.info("get key:" + k);
        return (V) getRedisTemplate().opsForHash().get(this.cacheName, k.toString());
    }

    @Override
    public V put(K k, V v) throws CacheException {
        log.info("put key: " + k + " value:" + v);
        getRedisTemplate().opsForHash().put(this.cacheName, k.toString(), v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        log.info("=============remove=============");
        return (V) getRedisTemplate().opsForHash().delete(this.cacheName, k.toString());
    }

    @Override
    public void clear() throws CacheException {
        log.info("=============clear=============");
        getRedisTemplate().delete(this.cacheName);
    }

    @Override
    public int size() {
        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    @Override
    public Set<K> keys() {
        return getRedisTemplate().opsForHash().keys(this.cacheName);
    }

    @Override
    public Collection<V> values() {
        return getRedisTemplate().opsForHash().values(this.cacheName);
    }

}
