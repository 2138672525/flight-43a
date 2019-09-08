package com.haina.flight.service;

import com.haina.flight.model.FlightPrice;

import java.util.List;

public interface ICacheService {

    /**
     * 根据出发-到达-出发时间，从缓存中读取数据
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    List<FlightPrice> getFromCache(String origin,
                                   String dest, String departDate);

    /**
     * 缓存航班数据, key example：BJS-BKK-2019-05-20
     * @param origin
     * @param dest
     * @param departDate
     * @param flightPriceList
     */
    void cacheFlight(String origin, String dest,
                     String departDate, List<FlightPrice> flightPriceList);
}
