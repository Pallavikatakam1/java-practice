package com.questk2.main;

public class ECommerce {
	private String orderId;
	private String name;
	private boolean processed;

	public ECommerce(String orderId, String name, boolean processed) {
		this.orderId = orderId;
		this.name = name;
		this.processed = processed;
	}

	public String toString() {
		return "Order Id : " + orderId + " Customer : " + name + " Processed : " + processed;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getCustomer() {
		return name;
	}

	public boolean getProcessed() {
		return processed;
	}

	public void orderProcessed() {
		this.processed = true;
	}

}
