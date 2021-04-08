package com.labhi.stocktradinghistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockTradingHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockTradingHistoryApplication.class, args);
	}

}
