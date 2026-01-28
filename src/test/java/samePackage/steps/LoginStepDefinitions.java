package samePackage.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.context.TextContext;
import samePackage.pages.AccountPage;
import samePackage.pages.StorePage;
import java.awt.*;


public class LoginStepDefinitions {

    private final WebDriver driver;
    public LoginStepDefinitions(TextContext context) {
        this.driver = context.driver;
    }

    @Given("I am in the login page")
        public void i_am_in_the_login_page() {

            new StorePage(driver).load(EndPoints.ACCOUNT.url);
        }

        @When("I enter valid {string} with {string}")
        public void i_enter_valid_with(String username, String password) {
        new AccountPage(driver).loginCredentials(username,password);

        }

    @Then("I should see the status alertMessage {string}")
    public void iShouldSeeTheStatusAlertMessage(String message) {
            Assert.assertEquals(new AccountPage(driver).SuccessfullyLoginStatusMessage(),message,"Not match");

        }

    @Then("I should see the errorMessage {string}")
    public void iShouldSeeTheErrorMessage(String message ) {
        Assert.assertEquals(new AccountPage(driver).errorLoginStatusMessage(),message,"Not match");
    }
}
