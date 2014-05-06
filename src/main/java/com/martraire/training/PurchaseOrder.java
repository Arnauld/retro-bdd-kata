package com.martraire.training;

public class PurchaseOrder {

	public static enum ProcessingState {
		ORDER_DONE, ORDER_CONFIRMED, ORDER_SHIPPING, ORDER_DELIVERED
	}

	private long id;
	private String label;
	private ProcessingState status;

	public PurchaseOrder(long id, String label, ProcessingState status) {
		this.id = id;
		this.label = label;
		this.status = status;
	}

	public boolean isCancellable() {
		if (status == ProcessingState.ORDER_DONE) {
			return true;
		} else if (status == ProcessingState.ORDER_CONFIRMED) {
			return true;
		} else {
			return false;
		}
	}

}
