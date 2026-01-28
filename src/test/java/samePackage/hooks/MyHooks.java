package samePackage.hooks;

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
    }
    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

}
