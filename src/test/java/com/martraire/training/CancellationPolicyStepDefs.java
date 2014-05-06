package com.martraire.training;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;


public class CancellationPolicyStepDefs {

	// TODO fill in steps here
	
	@Given("^something$")
	public void something() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   throw new PendingException();
	}

	@When("^I do something else$")
	public void I_do_something_else() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I expect a result$")
	public void I_expect_a_result() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
