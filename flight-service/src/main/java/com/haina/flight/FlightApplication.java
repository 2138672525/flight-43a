package com.haina.flight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.haina.flight.dao")
@SpringBootApplication
public class FlightApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightApplication.class);
    }
}
