package samePackage.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FactoryDriver {

    public static WebDriver initializeDriver(String browser) {

        if (browser == null || browser.isBlank()) {
            throw new RuntimeException(
                    "Browser is NULL or empty. Check config or Hooks."
            );
        }

        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.chromedriver().setup();

                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException(
                    "INVALID BROWSER: " + browser
            );
        }

        driver.manage().window().maximize();
        return driver;
    }
}
