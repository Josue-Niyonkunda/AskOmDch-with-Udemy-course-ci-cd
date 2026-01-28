package samePackage.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.constants.MyClass;
import samePackage.context.TextContext;
import samePackage.factory.FactoryDriver;
import samePackage.pages.StorePage;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class filterStepsDefinition {
    private final WebDriver driver;
    public filterStepsDefinition(TextContext context) {
        this.driver = context.driver;
    }

    @Given("the user is on the online shop store page")
    public void the_user_is_on_the_online_shop_store_page() {
        new StorePage(driver).load(MyClass.STORE);

    }
    private final By formSlider= By.cssSelector(".price_slider_wrapper");
    private final By filterButton= By.cssSelector("button.button[type='submit']");

    @When("the user enters product price range {int} and {int} and click the filter button")
    public void the_user_enters_product_price_range_and_click_the_filter_button(Integer minV, Integer maxV) {
       new StorePage(driver).setPriceRange(minV,maxV);

    }

    @Then("only products from range of {int} and {int} should be displayed")
    public void only_products_from_range_of_and_should_be_displayed(Integer minV, Integer maxV) {
        new StorePage(driver).priceRangeDisplayer(minV, maxV);

    }}

