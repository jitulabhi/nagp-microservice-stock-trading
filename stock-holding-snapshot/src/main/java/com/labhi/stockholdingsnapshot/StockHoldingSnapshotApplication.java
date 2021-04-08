package com.labhi.stockholdingsnapshot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockHoldingSnapshotApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockHoldingSnapshotApplication.class, args);
	}

}
