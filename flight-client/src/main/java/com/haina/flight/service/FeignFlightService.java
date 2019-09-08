package com.haina.flight.service;

import com.haina.flight.model.Flight;
import com.haina.flight.request.FlightRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fegin-flight-service")
public interface FeignFlightService {
    /**
     * 根据出发-到达-出发时间 ，查询航班列表
     * @return
     */
    @RequestMapping(value = "getFlightByFeign", method = RequestMethod.POST)
    List<Flight> getFlightByODAndDepartDate(FlightRequest request);

}










