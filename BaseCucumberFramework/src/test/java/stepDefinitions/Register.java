package stepDefinitions;

import java.util.List;

import org.framework.base.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	Base base;
	
	public Register(Base base) {
		this.base=base;
	}
	
	

	@Given("url is navigated to register page")
	public void url_is_navigated_to_register_page() {
	   
	    base.driver.findElement(By.partialLinkText("Register")).click();
	    
	}
	
	@When("user enters valid credentials")
	public void user_enters_valid_credentials(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		base.driver.findElement(By.xpath("//input[@value='"+data.get(1).get(0)+"']")).click();
		base.driver.findElement(By.id("FirstName")).sendKeys(data.get(1).get(1));
		base.driver.findElement(By.id("LastName")).sendKeys(data.get(1).get(2));
		base.driver.findElement(By.id("Email")).sendKeys(data.get(1).get(3));
		base.driver.findElement(By.id("Password")).sendKeys(data.get(1).get(4));
		base.driver.findElement(By.id("ConfirmPassword")).sendKeys(data.get(1).get(4));
	}
	
	/*
	 * @When("user enters valid credentials") public void
	 * user_enters_valid_credentials() {
	 * driver.findElement(By.id("gender-female")).click();
	 * driver.findElement(By.id("FirstName")).sendKeys("UserTest");
	 * driver.findElement(By.id("LastName")).sendKeys("QA");
	 * driver.findElement(By.id("Email")).sendKeys("usertest_qa@gmail.com");
	 * driver.findElement(By.id("Password")).sendKeys("Password@123");
	 * driver.findElement(By.id("ConfirmPassword")).sendKeys("Password@123");
	 * 
	 * }
	 */
	 

	@When("clicks on register button")
	public void clicks_on_register_button() {
	   base.driver.findElement(By.id("register-button")).click();
	}

	@Then("a new account should be created")
	public void a_new_account_should_be_created() {
	    Assert.assertTrue(base.driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed());
	}

	
}
