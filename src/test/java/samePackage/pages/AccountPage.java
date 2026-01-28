package samePackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public void loginCredentials(String username,String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(" p:nth-child(3) button")).click();
    }
    public String SuccessfullyLoginStatusMessage(){
        WebElement text =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(" p:nth-child(2)"))));
        System.out.println(text.getText());
        return text.getText();

    }
    public String errorLoginStatusMessage(){
        WebElement text= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        System.out.println(text.getText());
        return text.getText();

    }
    public static void registrationCredentials(String username,String email,String password){
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.name("register")).click();
    }
    public static void registrationStatus(String message){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement errorMessage= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        Assert.assertEquals(errorMessage.getText(),message,"Not match");
        System.out.println(errorMessage.getText());
    }
    public void clickOnPasswordResetLink(){

        driver.findElement(By.linkText("Lost your password?")).click();
    }
    public void resetPassword(String username){
        driver.findElement(By.cssSelector(".woocommerce-Input.woocommerce-Input--text.input-text"))
        .sendKeys(username);
        driver.findElement(By.cssSelector(".woocommerce-Button.button")).click();


    }
    public String resetMessage(){
         WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message[role='alert']")));
         return text.getText();
    }
}
