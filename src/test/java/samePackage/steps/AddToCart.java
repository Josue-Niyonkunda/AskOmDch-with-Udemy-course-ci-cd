package samePackage.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.context.TextContext;
import samePackage.pages.CartPage;
import samePackage.pages.HomePage;



public class AddToCart {
    private final WebDriver driver;

    public AddToCart(TextContext context) {
        this.driver=context.driver;
    }

    @Given("I am on home page")
    public void i_am_on_home_page() {
   new HomePage(driver).load(EndPoints.HOME.url);
    }
    @When("I add two products to the cart")
    public void i_add_two_products_to_the_cart() {
        new  HomePage(driver).addTwoProductsToCart();

    }
    @Then("products added to the cart")
    public void products_added_to_the_cart() {
        Assert.assertEquals(new CartPage(driver).viewCarts(),"2","Not match");

    }
}
