package samePackage.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.context.TextContext;
import samePackage.pages.AccountPage;

public class ResetPasswordSteps {
    public ResetPasswordSteps(TextContext context ){
        this.driver = context.driver;
    }

    private final WebDriver driver;
    @Then("I click reset link")
    public void i_click_reset_link() {
  new AccountPage(driver).clickOnPasswordResetLink();
    }
    @And("I reset my password  with {string}")
    public void i_reset_my_password_with(String username) {
        new AccountPage(driver).resetPassword(username);

    }
    @Then("I should see an alertResetMessage {string}")
    public void i_should_see_an_alert_reset_message(String message) {
        System.out.println(new AccountPage(driver).resetMessage());
        Assert.assertEquals(new AccountPage(driver).resetMessage(),message,"Reset functionality has failed." );

    }
}
