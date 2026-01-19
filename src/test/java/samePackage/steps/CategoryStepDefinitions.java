package samePackege.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import samePackege.factory.FactoryDriver;

import java.time.Duration;

public class CategoryStepDefinitions {
    private WebDriver driver;

    @Given("the user is on the online shop homepage")
    public void the_user_is_on_the_online_shop_homepage() {
     driver= FactoryDriver.getDriver();
     System.out.println("Tthe driver:"+driver);
        driver.findElement(By.linkText("Store")).click();
    }
    @When("the user selects {string} from the category dropdown")
    public void the_user_selects_accessories_from_the_category_dropdown(String category) {

        var tit=driver.findElement(By.cssSelector(".dropdown_product_cat"));
        tit.click();
        Select select=new Select(tit);
        select.selectByValue(category);

    }
    @Then("only products from {string} category should be displayed")
    public void only_products_from_accessories_category_should_be_displayed(String category) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));

        String firstThreeChars = category.length() >= 3 ? category.substring(0, 3) : category;
        Assert.assertTrue(text.getText().toLowerCase().contains(firstThreeChars)
        );
        System.out.println(text.getText());
    }

}
