package samePackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String viewCarts(){
        WebElement cartValueHolder= driver.findElements(By.cssSelector("span[class='count']")).get(0);
       return cartValueHolder.getText();

    }
    public void cartPage(){
        driver.findElement(By.cssSelector("[data-product_id='1215']")).click();
        driver.findElement(By.cssSelector("[data-product_id='1209']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//a[contains(@class,'added_to_cart')]"))).click();
    }
public void updateProductFromCartPage(){
    driver.findElement(By.name("cart[a4d2f0d23dcc84ce983ff9157f8b7f88][qty]")).sendKeys(Keys.ARROW_UP);
    driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_UP);
    driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_DOWN);
    driver.findElement(By.name("update_cart")).click();
}
    public String getUpdateMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message"))).getText();
    }
    public void deleteProductFromCartPage(){
        driver.findElement(By.name("cart[a4d2f0d23dcc84ce983ff9157f8b7f88][qty]")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("[data-product_id='1215']")).click();
    }

    public String getDeleteMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message"))).getText();
    }
    public void clickCheckoutButton() {
        By checkoutBtn = By.cssSelector("a.checkout-button.button.alt.wc-forward");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }
    public String getCartPage() {

        By message = By.cssSelector(".has-text-align-center");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message))
                .getText();
    }


}
