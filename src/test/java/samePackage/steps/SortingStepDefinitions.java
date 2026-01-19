package samePackage.steps;

import samePackage.constants.EndPoints;
import samePackage.factory.FactoryDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import samePackage.pages.StorePage;

import static samePackage.factory.FactoryDriver.driver;


public class SortingStepdefintions {

    @When("the user selects {string} from the sorting dropdown")
    public void the_user_selects_from_the_sorting_dropdown(String option) {

        new StorePage(driver).load(EndPoints.STORE.url);
        var optionlocator=driver.findElement(By.cssSelector("select.orderby"));
        optionlocator.click();
        Select select= new Select(optionlocator);
        select.selectByVisibleText(option);
    }
    @Then("only products from {string} sorting should be displayed")
    public void only_products_from_sorting_should_be_displayed(String option) {
        System.out.println("The products are displayed according to this "+ option.toUpperCase());
        System.out.println(driver.getCurrentUrl());
    }
}
