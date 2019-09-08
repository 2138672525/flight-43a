package com.haina.flight.service.impl;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.service.ICacheService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements ICacheService {
    @Resource
    private RedisTemplate<String, List<FlightPrice>> redisTemplate;

    private Cache<String, List<FlightPrice>> localCache = CacheBuilder
            .newBuilder()
            .concurrencyLevel(10)
            .expireAfterWrite(20, TimeUnit.SECONDS)
            .build();

    @Override
    public List<FlightPrice> getFromCache(String origin, String dest, String departDate) {
        String key = getKey(origin, dest, departDate);
        List<FlightPrice> list = localCache.getIfPresent(key);
        if(CollectionUtils.isNotEmpty(list)){
            System.out.println("read from local");
            return list;
        }

        List<FlightPrice> redisData = redisTemplate.opsForValue().get(key);
        if(CollectionUtils.isNotEmpty(redisData)){
            System.out.println("read from redis, and update local");
            localCache.put(key, redisData);
        }
        return redisData;
    }

    @Override
    public void cacheFlight(String origin, String dest, String departDate, List<FlightPrice> flightPriceList) {
        String key = getKey(origin, dest, departDate);
        redisTemplate.opsForValue().set(key, flightPriceList);
    }

    /**
     * 根据出发-到达-出发时间，生成缓存key
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    private String getKey(String origin, String dest, String departDate){
        return Joiner.on("-").join(origin, dest, departDate);
    }
}
