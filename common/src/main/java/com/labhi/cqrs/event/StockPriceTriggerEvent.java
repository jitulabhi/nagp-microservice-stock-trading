package com.labhi.cqrs.event;

public class StockPriceTriggerEvent {
	public String triggerId;
	public String stockId;
	public String stockName;
	public String customerId;
	public double threshold;
	public long quantity;
	public StockPriceTriggerEvent(String triggerId, String stockId, String stockName, String customerId,
			double threshold, long quantity) {
		super();
		this.triggerId = triggerId;
		this.stockId = stockId;
		this.stockName = stockName;
		this.customerId = customerId;
		this.threshold = threshold;
		this.quantity = quantity;
	}
	
	
}
