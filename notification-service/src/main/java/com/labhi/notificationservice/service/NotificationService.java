package com.labhi.notificationservice.service;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.labhi.cqrs.event.DepositEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationService {
	
	@EventHandler
	public void on(DepositEvent event) {
		log.info("Hi Customer {} there is a deposit of {} in your account", event.customerId, event.amount);
	}

}
