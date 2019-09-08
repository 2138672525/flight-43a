package com.haina.flight.feign;

import com.haina.flight.model.Flight;
import com.haina.flight.model.FlightPrice;
import com.haina.flight.request.FlightRequest;
import com.haina.flight.service.FeignFlightService;
import com.haina.flight.service.IFlightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeignFlightServiceImpl implements FeignFlightService {
    @Resource
    private IFlightService flightService;

    @Override
    public List<Flight> getFlightByODAndDepartDate(@RequestBody FlightRequest request) {
        List<FlightPrice> flightPrice = flightService.getFlightPrice(
                request.getOrigin(), request.getDest(), request.getDepartDate());
        return flightPrice.stream().map(this::convertFlightPrice)
                .collect(Collectors.toList());
    }

    //类型转换，把flightPrice类型转换成flight类型
    private Flight convertFlightPrice(FlightPrice flightPrice){
        Flight result = new Flight();
        result.setId(flightPrice.getId());
        result.setOrigin(flightPrice.getOrigin());
        result.setDest(flightPrice.getDest());
        result.setBaggage(flightPrice.getBaggage());
        result.setRule(flightPrice.getRule());
        result.setDepartDate(flightPrice.getDepartDate());
        result.setDepartTime(flightPrice.getDepartTime());
        result.setArrivalDate(flightPrice.getArrivalDate());
        result.setArrivalTime(flightPrice.getArrivalTime());
        result.setCarrier(flightPrice.getCarrier());
        result.setFlightNo(flightPrice.getFlightNo());
        result.setAircraft(flightPrice.getAircraft());
        result.setActFlightNo(flightPrice.getActFlightNo());
        result.setActCarrier(flightPrice.getActCarrier());
        result.setPrice(flightPrice.getPrice());
        return result;
    }

}









