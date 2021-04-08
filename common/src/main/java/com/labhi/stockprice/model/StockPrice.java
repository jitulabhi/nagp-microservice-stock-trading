package com.labhi.stockprice.model;

public class StockPrice extends StockPriceEvent{

	private String stockId;
	private String stockName;
	private double buyPrice;
	private double sellPrice;
	
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
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
	
	@Override
	public String toString() {
		return "StockPrice [stockId=" + stockId + ", stockName=" + stockName + ", buyPrice=" + buyPrice
				+ ", sellPrice=" + sellPrice + "]";
	}
	
	
	
	
	
	
	
}
