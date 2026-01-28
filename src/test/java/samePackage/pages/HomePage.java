package samePackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void addTwoProductsToCart(){
        driver.findElement(By.cssSelector("[data-product_id='1215']")).click();
        driver.findElement(By.cssSelector("[data-product_id='1209']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//a[contains(@class,'added_to_cart')]"))).click();

    }

}
