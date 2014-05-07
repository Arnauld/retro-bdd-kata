package com.martraire.training;

import com.martraire.training.PurchaseOrder.ProcessingState;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CancellationPolicyStepDefs {

    public static final long DEFAULT_ID = 17L;
    public static final String DEFAULT_LABEL = "Label";
    public static final int DEFAULT_CANCELLATION_NUMBER = 11;

    private PurchaseOrder purchaseOrder;
    private CancellationPolicy cancellationPolicy;
    private Features features;

    @Before
    public void initContext() {
        features = new Features();
        cancellationPolicy = new CancellationPolicy(features);
    }

    @Given("^a done order$")
    public void createADoneOrder() {
        createOrderWithStatus(ProcessingState.ORDER_DONE);
    }

    private void createOrderWithStatus(ProcessingState status) {
        createOrderWithStatusAndCancellationNumber(status, DEFAULT_CANCELLATION_NUMBER);
    }

    private void createOrderWithStatusAndCancellationNumber(ProcessingState status, int cancellationNumber) {
        purchaseOrder = new PurchaseOrder(DEFAULT_ID, cancellationNumber, DEFAULT_LABEL, status);
    }

    @Given("^a shipped order$")
    public void createAShippedOrder() {
        createOrderWithStatus(ProcessingState.ORDER_SHIPPING);
    }

    @Given("^the shipped cancellation policy is activated$")
    public void activateFeatureShippingCancellationPolicy() {
        features.setShippedCancellationPolicyActivation(true);
    }

    @Given("^the shipped cancellation policy is not activated$")
    public void deactivateFeatureShippingCancellationPolicy() {
        features.setShippedCancellationPolicyActivation(false);
    }

    @Given("^a shipped order with the cancellation number (\\d+)$")
    public void createAShippedOrderWithCancellationNumber(int cancellationNumber) {
        createOrderWithStatusAndCancellationNumber(ProcessingState.ORDER_SHIPPING, cancellationNumber);
    }

    @Then("^the order should be cancellable$")
    public void assertOrderIsCancellable() {
        assertThat(cancellationPolicy.isCancellable(purchaseOrder)).isTrue();
    }

    @Then("^the order should not be cancellable$")
    public void assertOrderIsNotCancellable() {
        assertThat(cancellationPolicy.isCancellable(purchaseOrder)).isFalse();
    }

    @Then("^the order should [ ]?be cancellable with the cancellation number (\\d+)$")
    public void assertOrderIsCancellableWithCancellationNumber(int clientCancellationNumber) {
        assertThat(cancellationPolicy.isCancellable(purchaseOrder, clientCancellationNumber)).isTrue();
    }

    @Then("^the order should not be cancellable with the cancellation number (\\d+)$")
    public void assertOrderIsNotCancellableWithCancellationNumber(int clientCancellationNumber) {
        assertThat(cancellationPolicy.isCancellable(purchaseOrder, clientCancellationNumber)).isFalse();
    }

    @Then("^the shipped cancellation policy should not be activated$")
    public void the_shipped_cancellation_policy_should_not_be_activated() throws Throwable {
        assertThat(features.isShippedCancellationPolicyActivated()).isFalse();
    }
}
