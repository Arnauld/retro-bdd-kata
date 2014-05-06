package com.martraire.training;

import org.junit.Assert;

import com.martraire.training.PurchaseOrder.ProcessingState;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CancellationPolicyStepDefs {

	private PurchaseOrder purchaseOrder;

	@Given("^a done order$")
	public void createADoneOrder() throws Throwable {
		purchaseOrder = new PurchaseOrder(17L, "Label",
				ProcessingState.ORDER_DONE);
	}

	@Given("^a shipped order$")
	public void a_shipped_order() throws Throwable {
		purchaseOrder = new PurchaseOrder(17L, "Label",
				ProcessingState.ORDER_SHIPPING);
	}

	@Then("^the order should be cancellable$")
	public void the_order_should_be_cancellable() throws Throwable {
		Assert.assertTrue(purchaseOrder.isCancellable());
	}

	@Then("^the order should not be cancellable$")
	public void the_order_should_not_be_cancellable() throws Throwable {
		Assert.assertFalse(purchaseOrder.isCancellable());
	}

	@Given("^the shipped cancellation policy is activated$")
	public void the_shipped_cancellation_policy_is_activated() throws Throwable {
		Features.shippedCancellationPolicy = true;
	}

	@Given("^a shipped order with the cancellation number (\\d+)$")
	public void a_shipped_order_with_the_cancellation_number(
			int cancellationNumber) throws Throwable {
		purchaseOrder = new PurchaseOrder(17L, cancellationNumber, "Label",
				ProcessingState.ORDER_SHIPPING);
	}

	@Then("^the order should [ ]?be cancellable with the cancellation number (\\d+)$")
	public void the_order_should_be_cancellable_with_the_cancellation_number(
			int clientCancellationNumber) throws Throwable {
		Assert.assertTrue(purchaseOrder.isCancellable(clientCancellationNumber));
	}
	
	@Then("^the order should not be cancellable with the cancellation number (\\d+)$")
	public void the_order_should_not_be_cancellable_with_the_cancellation_number(int clientCancellationNumber) throws Throwable {
		Assert.assertFalse(purchaseOrder.isCancellable(clientCancellationNumber));
	}

}
