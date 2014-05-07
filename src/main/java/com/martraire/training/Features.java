package com.martraire.training;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Features {
    private boolean shippedCancellationPolicy = false;

    public boolean isShippedCancellationPolicyActivated() {
        return shippedCancellationPolicy;
    }

    public void setShippedCancellationPolicyActivation(boolean isShippedCancellationPolicyActivated) {
        this.shippedCancellationPolicy = isShippedCancellationPolicyActivated;
    }
}
