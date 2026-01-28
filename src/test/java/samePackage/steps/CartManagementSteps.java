package samePackage.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.context.TextContext;
import samePackage.pages.CartPage;
import samePackage.pages.HomePage;

public class CartManagementSteps {

    private final WebDriver driver;
    public CartManagementSteps(TextContext context) {
        this.driver = context.driver;
    }

    @Given("I am on cart page")
    public void i_am_on_cart_page() {
        new HomePage(driver).load(EndPoints.HOME.url);
       new CartPage(driver).cartPage();

    }
    @When("I want to increment each product by one")
    public void i_want_to_increment_each_product_by_one() {
     new CartPage(driver).updateProductFromCartPage();
    }
    @When("I want to delete the product")
    public void i_want_to_delete_the_product() {
        new CartPage(driver).deleteProductFromCartPage();
    }
    @Then("I should see an delete confirmation")
    public void i_should_see_an_delete_confirmation() {
        System.out.println(new CartPage(driver).getDeleteMessage());
        Assert.assertEquals( new CartPage(driver).getDeleteMessage(),"“Blue Shoes” removed. Undo?","Delete functionality failed");
    }

    @Then("I should see an update confirmation")
    public void iShouldSeeAnUpdateConfirmation() {
        System.out.println(new CartPage(driver).getUpdateMessage());
        Assert.assertEquals(new CartPage(driver).getUpdateMessage(),"Cart updated.","Update went wrong");
    }
}
