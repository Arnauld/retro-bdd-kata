package com.martraire.training;

public class PurchaseOrder {

    private static final int UNDEFINED = Integer.MIN_VALUE;


    public static enum ProcessingState {
        ORDER_DONE, ORDER_CONFIRMED, ORDER_SHIPPING, ORDER_DELIVERED
    }

    private final long id;
    private final int cancellationNumber;
    private final String label;
    private final ProcessingState status;

    public PurchaseOrder(long id, int cancellationNumber, String label, ProcessingState status) {
        this.id = id;
        this.cancellationNumber = cancellationNumber;
        this.label = label;
        this.status = status;
    }

    public ProcessingState getStatus() {
        return status;
    }

    public boolean isCancellationNumberValid(int cancellationNumber) {
        return cancellationNumber == this.cancellationNumber;
    }

}
