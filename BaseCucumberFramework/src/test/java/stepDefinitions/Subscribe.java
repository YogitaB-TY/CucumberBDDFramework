package stepDefinitions;

import org.framework.base.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Subscribe {
	Base base;
	public Subscribe(Base base) {
		this.base=base;
	}
	
	@When("user enters valid email id and clicks on subscribe button")
	public void user_enters_valid_email_id_and_clicks_on_subscribe_button() {
	   
	}
	@Then("user should be able to successfully subscribe")
	public void user_should_be_able_to_successfully_subscribe() {
	    
	}

}
