package com.labhi.stockpricestoreservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

@Configuration
public class MongoDbConfig {
	
	@Bean
	public MongoClient mongoClient(@Value("${camel.component.mongodb3.uri}") String uri) {
		return new MongoClient(new MongoClientURI(uri));
	}

}
