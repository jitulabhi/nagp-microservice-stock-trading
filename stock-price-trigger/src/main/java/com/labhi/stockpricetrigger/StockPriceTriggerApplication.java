package com.labhi.stockpricetrigger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockPriceTriggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceTriggerApplication.class, args);
	}

}
