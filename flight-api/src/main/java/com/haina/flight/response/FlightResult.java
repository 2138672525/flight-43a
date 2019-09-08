package com.haina.flight.response;

import com.haina.flight.model.Flight;
import com.haina.flight.request.FlightRequest;

import java.util.List;

public class FlightResult {
    private int code;
    private String msg;
    private List<Flight> data;

    public static FlightResult success(List<Flight> data){
        FlightResult result = new FlightResult();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static FlightResult fail(){
        FlightResult result = new FlightResult();
        result.setCode(1);
        result.setMsg("system error");
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Flight> getData() {
        return data;
    }

    public void setData(List<Flight> data) {
        this.data = data;
    }
}
