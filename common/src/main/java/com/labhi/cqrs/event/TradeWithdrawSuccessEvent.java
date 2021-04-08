package com.labhi.cqrs.event;

public class TradeWithdrawSuccessEvent {

	public String tradeId;
	public String transactionId;

	public TradeWithdrawSuccessEvent(String tradeId, String transactionId) {
		super();
		this.tradeId = tradeId;
		this.transactionId = transactionId;
	}

}
