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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterSteps {

    private WebDriver driver;
    @Given("I am in the contact page")
    public void i_am_in_the_contact_page() {
        driver=new ChromeDriver();
        driver.findElement(By.linkText("Account")).click();
    }

    @When("I enter credentials {string} with {string} with {string}")
    public void i_enter_credentials_with_with(String username, String email, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.cssSelector(".woocommerce-form-register__submit")).click();
    }
    @Then("I should not be registered")
    public void i_should_not_be_registered() {

        driver.findElement(By.name("register")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        WebElement errorMessage=driver.findElement(By.cssSelector(".woocommerce-error"));
                Assert.assertEquals(errorMessage.getText(),"Error: An account is already registered with that username. Please choose another.","Not match");
    System.out.println(errorMessage.getText());
    }
    @Then("I should not be registered on the website")
    public void i_should_not_be_registered_on_the_website() {

        driver.findElement(By.name("register")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        WebElement errorMessage=driver.findElement(By.cssSelector(".woocommerce-error"));
        Assert.assertEquals(errorMessage.getText(),"Error: Please provide a valid email address.","Not match");
        System.out.println(errorMessage.getText());
    }
    @Then("I should not be registered on the on the online shop")
    public void i_should_not_be_registered_on_the_on_the_online_shop() {

        driver.findElement(By.name("register")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        WebElement errorMessage=driver.findElement(By.cssSelector(".woocommerce-error"));
        Assert.assertEquals(errorMessage.getText(),"Error: Please provide a valid email address.","Not match");
        System.out.println(errorMessage.getText());
    }
}
