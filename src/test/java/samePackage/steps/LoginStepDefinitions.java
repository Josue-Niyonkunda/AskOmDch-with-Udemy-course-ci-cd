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

public class LoginStepDefinitions {

    private WebDriver driver;
        @Given("I am in the login page")
        public void i_am_in_the_login_page() {
            driver=new ChromeDriver();
            driver.findElement(By.linkText("Account")).click();
        }

        @When("I enter valid {string} with {string}")
        public void i_enter_valid_with(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
           driver.findElement(By.cssSelector(" p:nth-child(3) button")).click();
        }

        @Then("I should be taken to the Overview page")
        public void i_should_be_taken_to_the_overview_page() {

            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(" p:nth-child(2)"))));
            WebElement text=driver.findElement(By.cssSelector(" p:nth-child(2)"));
            Assert.assertEquals(text.getText(),"Hello josue (not josue? Log out)","Not match");
            System.out.println(text.getText());
        }

    @When("I enter invalid password {string} with {string}")
    public void i_enter_invalid_password_with(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.cssSelector(" p:nth-child(3) button")).click();
    }

    @When("I enter invalid username {string} with {string}")
    public void i_enter_invalid_username_with(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(" p:nth-child(3) button")).click();
    }

    @Then("I should not be taken to the Overview page")
    public void i_should_not_be_taken_to_the_overview_page() {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"))));
        WebElement text=driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"));
        Assert.assertEquals(text.getText(),"Error: The password you entered for the username josue is incorrect. Lost your password?","Not match");
        System.out.println(text.getText());
    }

    @Then("I should not be able to login to the page")
    public void i_should_not_be_able_to_login_to_the_page() {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"))));
        WebElement text=driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"));
        Assert.assertEquals(text.getText(),"Error: The username josueniyonkunda is not registered on this site. If you are unsure of your username, try your email address instead.","Not match");
        System.out.println(text.getText());
    }
    @When("I enter invalid with empty credentials {string} with {string}")
    public void i_enter_invalid_with_empty_credentials_with(String username, String password) {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(" p:nth-child(3) button")).click();
    }
    @Then("I should not be logged to the login page")
    public void i_should_not_be_logged_to_the_login_page() {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"))));
        WebElement text=driver.findElement(By.cssSelector("div.woocommerce-notices-wrapper > ul > li"));
        Assert.assertEquals(text.getText(),"Error: Username is required.","Not match");
        System.out.println(text.getText());

    }

    }
