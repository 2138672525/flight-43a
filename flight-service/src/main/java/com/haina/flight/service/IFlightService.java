package com.haina.flight.service;

import com.haina.flight.model.FlightPrice;

import java.util.List;

/**
 * 航班业务接口
 */
public interface IFlightService {

    /**
     * 通过出发-到达-出发时间  查询航班数据
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    List<FlightPrice> getFlightPrice(
            String origin, String dest, String departDate);
}






