package com.haina.flight.service.impl;

import com.haina.flight.dao.FlightPriceMapper;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.service.ICacheService;
import com.haina.flight.service.IFlightService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {
    @Resource
    private FlightPriceMapper flightPriceMapper;
    @Resource
    private ICacheService cacheService;

    @Override
    public List<FlightPrice> getFlightPrice(String origin, String dest, String departDate) {
        //从缓存中读取数据
        List<FlightPrice> cache = cacheService.getFromCache(origin,
                dest, departDate);
        if(CollectionUtils.isNotEmpty(cache)){
            System.out.println("read from cache");
            return cache;
        }
        //从数据库中查询
        List<FlightPrice> db = flightPriceMapper.selectFlightByODAndDepartDate(
                origin, dest, departDate);
        //如果数据库中有数据，则插入到缓存
        if(CollectionUtils.isNotEmpty(db)){
            System.out.println("read from db, and save cache");
            cacheService.cacheFlight(origin, dest, departDate, db);
        }


        return db;
    }
}









