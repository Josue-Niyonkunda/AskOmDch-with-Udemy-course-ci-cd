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

        // driver = FactoryDriver.initializeDriver("firefox");
        driver = FactoryDriver.initializeDriver("chrome");
        context.driver=driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");          // Run without opening Chrome window
        options.addArguments("--disable-gpu");       // Disable GPU acceleration
        options.addArguments("--window-size=1920,1080");
    }
    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

}
