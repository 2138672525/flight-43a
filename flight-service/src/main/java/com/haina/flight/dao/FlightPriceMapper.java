package com.haina.flight.dao;

import com.haina.flight.model.FlightPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightPriceMapper {

    /**
     * 根据出发-到达-出发日期查询航班列表
     * @return
     */
    List<FlightPrice> selectFlightByODAndDepartDate(
            @Param("origin") String origin,
            @Param("dest") String dest,
            @Param("departDate") String departDate);
}