package com.hubix.apiconnector;

import com.hubix.apiconnector.service.RealTimeStockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ApiconnectorApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ApiconnectorApplication.class, args);

        RealTimeStockService realTimeStockService = new RealTimeStockService();

        realTimeStockService.runAnalysis("XBT");


    }
}





