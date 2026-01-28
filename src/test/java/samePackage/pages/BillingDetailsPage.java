package samePackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingDetailsPage extends BasePage {

    public BillingDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By firstName = By.id("billing_first_name");
    private final By lastName = By.id("billing_last_name");
    private final By countryDropdown = By.cssSelector(".select2-selection--single");
    private final By countryInput = By.cssSelector(".select2-search__field");
    private final By address = By.id("billing_address_1");
    private final By city = By.id("billing_city");
    private final By state = By.id("billing_state");
    private final By zip = By.id("billing_postcode");
    private final By email = By.id("billing_email");

    // Actions
    public void fillBillingDetails(
            String firstNameValue,
            String lastNameValue,
            String countryValue,
            String streetAddress,
            String cityValue,
            String stateValue,
            String zipValue,
            String emailValue
    ) {
        type(firstName, firstNameValue);
        type(lastName, lastNameValue);
        selectCountry(countryValue);
        type(address, streetAddress);
        type(city, cityValue);
        type(state, stateValue);
        type(zip, zipValue);
        type(email, emailValue);
    }

    private void type(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .clear();
        driver.findElement(locator).sendKeys(value);
    }

    private void selectCountry(String countryValue) {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryInput))
                .sendKeys(countryValue, Keys.ENTER);
    }


public void placeOrder(){
        driver.findElement(By.cssSelector(".button.alt[name='woocommerce_checkout_place_order']")).click();
    }
    public String checkSuccessfullyOrder(){
        return  driver.findElement(By.cssSelector("p.woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"))
                .getText();
    }
}
