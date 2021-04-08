package com.labhi.cqrs.command;

public class TradeWithdrawSuccessCommand {

	public String tradeId;
	public String transactionId;

	public TradeWithdrawSuccessCommand(String tradeId, String transactionId) {
		super();
		this.tradeId = tradeId;
		this.transactionId = transactionId;
	}

}
