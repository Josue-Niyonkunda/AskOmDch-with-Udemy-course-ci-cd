package samePackage.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.context.TextContext;
import samePackage.pages.BillingDetailsPage;
import samePackage.pages.CartPage;


public class PlaceAnOrderSteps {
    private final WebDriver driver;
    public PlaceAnOrderSteps(TextContext context) {
        this.driver = context.driver;
    }


    @Then("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
         new CartPage(driver).clickCheckoutButton();
        System.out.println(new CartPage(driver).getCartPage());
        Assert.assertEquals(new CartPage(driver).getCartPage(),"Checkout","Cart page failed to load");
    }

    @When("I place an order")
    public void iPlaceAnOrder() {
      new BillingDetailsPage(driver).placeOrder();


    }
    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
       new BillingDetailsPage(driver).checkSuccessfullyOrder();
        System.out.println( new BillingDetailsPage(driver).checkSuccessfullyOrder());
        Assert.assertEquals( new BillingDetailsPage(driver).checkSuccessfullyOrder(),"Thank you. Your order has been received.","Place order went wrong");
    }

}
