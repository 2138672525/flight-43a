package com.haina.flight.controller;

import com.haina.flight.model.Flight;
import com.haina.flight.request.FlightRequest;
import com.haina.flight.response.FlightResult;
import com.haina.flight.service.FeignFlightService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ApiController {
    //注入的对象，是feign帮我们自动生成的实现类的对象
    //flight-client包本身没有实现类，是rpc框架帮我们生成的实现类
    @Resource
    private FeignFlightService feignFlightService;

    @RequestMapping("getFlight")
    public FlightResult getFlight(String origin, String dest, String departDate){
        FlightRequest request = new FlightRequest();
        request.setOrigin(origin);
        request.setDest(dest);
        request.setDepartDate(departDate);
        List<Flight> list = feignFlightService.getFlightByODAndDepartDate(request);
        if(list != null && list.size() != 0){
            return FlightResult.success(list);
        }
        return FlightResult.fail();
    }
}




