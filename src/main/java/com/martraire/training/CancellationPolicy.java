package com.martraire.training;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CancellationPolicy {

    private final Features features;

    public CancellationPolicy(Features features) {
        this.features = features;
    }

    public boolean isCancellable(PurchaseOrder purchaseOrder) {
        return isCancellable(purchaseOrder, null);
    }

    public boolean isCancellable(PurchaseOrder purchaseOrder, Integer cancellationNumber) {
        PurchaseOrder.ProcessingState status = purchaseOrder.getStatus();

        switch (status) {

            case ORDER_DONE:
            case ORDER_CONFIRMED:
                return true;
            case ORDER_SHIPPING:
                return features.isShippedCancellationPolicyActivated()
                        && cancellationNumber != null
                        && purchaseOrder.isCancellationNumberValid(cancellationNumber);
            case ORDER_DELIVERED:
            default:
                return false;
        }
    }
}
