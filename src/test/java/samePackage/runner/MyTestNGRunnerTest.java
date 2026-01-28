package samePackage.runner;


import io.cucumber.messages.types.Tag;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;
@CucumberOptions(
        features = "src/test/resources/samePackage/feature",
        glue = {"samePackage.steps", "samePackage"}

        ,snippets =CAMELCASE,dryRun = false,tags = "not @PlaceOrder",
        plugin = {
                "pretty"
        }
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
