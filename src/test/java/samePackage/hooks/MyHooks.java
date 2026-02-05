package samePackage.hooks;

import org.openqa.selenium.chrome.ChromeOptions;
import samePackage.context.TextContext;
import samePackage.factory.FactoryDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TextContext context;

    public MyHooks(TextContext textContext){
        this.context = textContext;
    }

    @Before
    public void before(){
        // Create ChromeOptions first
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");               // Run without opening Chrome window
        options.addArguments("--disable-gpu");            // Disable GPU acceleration
        options.addArguments("--no-sandbox");             // Required for Linux CI/CD
        options.addArguments("--disable-dev-shm-usage");  // Fix shared memory issues in containers
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--ignore-certificate-errors"); // Optional: ignore SSL issues

        // Pass options to your FactoryDriver
        driver = FactoryDriver.initializeDriver("chrome", options);

        // Save driver in context
        context.driver = driver;
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
