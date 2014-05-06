package com.martraire.training;

import com.martraire.training.PurchaseOrder.ProcessingState;

public class PurchaseOrder {

	public static enum ProcessingState {
		ORDER_DONE, ORDER_CONFIRMED, ORDER_SHIPPING, ORDER_DELIVERED
	}

	private long id;
	private String label;
	private ProcessingState status;
	private int cancellationNumber;

	public PurchaseOrder(long id, String label, ProcessingState status) {
		this(id, -1, label, status);
	}

	public PurchaseOrder(long id, int cancellationNumber, String label,
			ProcessingState status) {
		this.id = id;
		this.cancellationNumber = cancellationNumber;
		this.label = label;
		this.status = status;
	}

	public boolean isCancellable() {
		return isCancellable(-2);
	}

	public boolean isCancellable(int clientCancellationNumber) {
		if (status == ProcessingState.ORDER_DONE) {
			return true;
		} else if (status == ProcessingState.ORDER_CONFIRMED) {
			return true;
		} else if (status == ProcessingState.ORDER_SHIPPING && Features.shippedCancellationPolicy) {
			return clientCancellationNumber == cancellationNumber;
		}
		else {
			return false;
		}
	}

}
