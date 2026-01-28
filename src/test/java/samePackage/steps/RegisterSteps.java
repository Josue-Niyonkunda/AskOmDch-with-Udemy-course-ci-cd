package samePackage.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.context.TextContext;
import samePackage.pages.AccountPage;
import samePackage.pages.PageFactoryManager;
import samePackage.pages.StorePage;

import java.time.Duration;

public class RegisterSteps {

    private final StorePage storePage;
    private final AccountPage accountPage;

    public RegisterSteps(TextContext context) {
        storePage= PageFactoryManager.getStorePage(context.driver);
        accountPage= PageFactoryManager.getAccountPage(context.driver);
    }

    @Given("I am in the contact page")
    public void i_am_in_the_contact_page() {
        storePage.load( EndPoints.ACCOUNT.url);
    }

    @When("I register my credentials {string} with {string} with {string}")
    public void i_register_my_credentials_with_with(String username, String email, String password) {
        AccountPage.registrationCredentials(username, email, password);
    }

    @Then("I should not be registered and see an alertErrorMessage {string}")
    public void iShouldNotBeRegisteredAndSeeAnAlertErrorMessage(String Message) {
   AccountPage.registrationStatus(Message);
    }


}
