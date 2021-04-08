package com.labhi.stocktrading.model;

public class StockTradingRequest {
	private String customerId;
	private String stockId;
	private String stockName;
	private long quantity;
	private double price;
	
	
	
	
	public StockTradingRequest() {
		super();
	}
	public StockTradingRequest(String customerId, String stockId, String stockName, long quantity, double price) {
		super();
		this.customerId = customerId;
		this.stockId = stockId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
