package samePackage.steps;

import org.openqa.selenium.WebDriver;
import samePackage.constants.EndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import samePackage.constants.MyClass;
import samePackage.context.TextContext;
import samePackage.pages.StorePage;

public class SortingStepDefinitions {
     private final WebDriver driver;
    public SortingStepDefinitions(TextContext context) {
        driver=context.driver;
    }

    @When("the user selects {string} from the sorting dropdown")
    public void the_user_selects_from_the_sorting_dropdown(String option) {

        new StorePage(driver).load(EndPoints.STORE.url);
        var optionLocator=driver.findElement(By.cssSelector("select.orderby"));
        optionLocator.click();
        Select select= new Select(optionLocator);
        select.selectByVisibleText(option);
    }
    @Then("only products from {string} sorting should be displayed")
    public void only_products_from_sorting_should_be_displayed(String option) {
        System.out.println("The products are displayed according to this "+ option.toUpperCase());
        System.out.println(driver.getCurrentUrl());
    }
}
