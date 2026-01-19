package samePackege.hooks;

import samePackege.factory.FactoryDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    @Before
    public void before(){
        driver= FactoryDriver.initializeDriver();
    }
    @After
    public void after(){
        driver.quit();
    }
}
