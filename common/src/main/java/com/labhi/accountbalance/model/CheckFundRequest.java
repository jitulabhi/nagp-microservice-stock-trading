package com.labhi.accountbalance.model;

public class CheckFundRequest {
	
	private String customerId;
	private double fund;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getFund() {
		return fund;
	}
	public void setFund(double fund) {
		this.fund = fund;
	}
	@Override
	public String toString() {
		return "CheckFundRequest [customerId=" + customerId + ", fund=" + fund + "]";
	}
	
	
	
	

}
