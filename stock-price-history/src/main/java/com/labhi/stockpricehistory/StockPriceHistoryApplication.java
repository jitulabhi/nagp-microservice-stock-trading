package com.labhi.stockpricehistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockPriceHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceHistoryApplication.class, args);
	}

}
