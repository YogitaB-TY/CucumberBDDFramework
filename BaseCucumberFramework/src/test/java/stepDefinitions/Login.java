package stepDefinitions;

import org.framework.base.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	Base base;

	public Login(Base base) {
		this.base = base;
	}

	@Given("Login page is displayed")
	public void login_page_is_displayed() {
		base.welcomePage.clickLoginLink();
	}

	@When("user enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
		base.driver.findElement(By.id("Email")).sendKeys("qa_testuser123@gmail.com");
		base.driver.findElement(By.id("Password")).sendKeys("Password@123");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		base.driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		Assert.assertTrue(base.driver.findElement(By.linkText("Log out")).isDisplayed());
	}

}
