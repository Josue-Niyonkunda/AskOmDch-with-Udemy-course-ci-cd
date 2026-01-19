package samePackege.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FactoryDriver {
    public static WebDriver driver;
    public static WebDriver initializeDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver(){
       return driver;
    }
}
