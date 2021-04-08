package com.labhi.accountbalance.model;

import java.io.Serializable;

public class CheckFundResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Boolean enough;

	

	public Boolean getEnough() {
		return enough;
	}



	public void setEnough(Boolean enough) {
		this.enough = enough;
	}



	@Override
	public String toString() {
		return "CheckFundResponse [enough=" + enough + "]";
	}
	
	
	
	

}
