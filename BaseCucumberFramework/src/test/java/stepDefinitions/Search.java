package stepDefinitions;

import org.framework.base.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	public String searchItem;
	Base base;

	public Search(Base base) {
		this.base = base;
	}

	@When("^user enters \"([^\"]*)\" in search text field$")
	public void user_enters_in_search_text_field(String searchItem) {
		this.searchItem = searchItem;
		base.driver.findElement(By.id("small-searchterms")).sendKeys(searchItem);
		base.driver.findElement(By.xpath("//input[@value='Search']")).click();
	}

	@Then("Search results must be displyaed")
	public void search_results_must_be_displyaed() {
		Assert.assertTrue(base.driver.findElement(By.name("Q")).getAttribute("value").contains(searchItem));

	}

}
