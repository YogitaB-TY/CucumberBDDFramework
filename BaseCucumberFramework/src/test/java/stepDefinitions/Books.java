package stepDefinitions;

import java.util.List;

import org.framework.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Books {
	Base base;

	public Books(Base base) {
		this.base = base;
	}

	@Given("browser is open to welcome page")
	public void browser_is_open_to_welcome_page() {
		System.out.println("Browser is open");
	}

	@When("user is logged in")
	public void user_is_logged_in(DataTable datatable) {
		List<List<String>> data = datatable.asLists();
		String userName = data.get(0).get(0);
		String password = data.get(0).get(1);
		base.driver.findElement(By.partialLinkText("Log in")).click();
		base.driver.findElement(By.id("Email")).sendKeys(userName);
		base.driver.findElement(By.id("Password")).sendKeys(password);
		base.driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@When("user clicks on Book page")
	public void user_clicks_on_book_page() {
		base.driver.findElement(By.partialLinkText("BOOKS")).click();
	}

	@When("Books page is displayed")
	public void books_page_is_displayed() {
		Assert.assertTrue(base.driver.getCurrentUrl().contains("books"));
	}

	@When("User chooses A-Z in sort by drop down")
	public void user_chooses_a_z_in_sort_by_drop_down() {
		Select select = new Select(base.driver.findElement(By.id("products-orderby")));
		select.selectByVisibleText("Name: A to Z");
	}

	@Then("page should be sorted alphabetically")
	public void page_should_be_sorted_alphabetically() {
		System.out.println("Page is sorted");
	}

	@When("user clicks on add to cart button for Computing and Internet book")
	public void user_clicks_on_add_to_cart_button_for_computing_and_internet_book() {
		base.driver.findElement(By.xpath("//a[text()='Computing and Internet']/../..//input")).click();
	}

	@Then("Book should be added to cart")
	public void book_should_be_added_to_cart() {
		Assert.assertEquals(
				base.driver.findElement(By.xpath("//p[text()='The product has been added to your ']")).getText(),
				"The product has been added to your ");

	}

	@When("user clicks on add to cart button for Health book")
	public void user_clicks_on_add_to_cart_button_for_health_book() {
		base.driver.findElement(By.xpath("//a[text()='Health Book']/../..//input")).click();
	}

}
