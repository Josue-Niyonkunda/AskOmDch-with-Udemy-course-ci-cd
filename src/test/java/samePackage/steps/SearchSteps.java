package samePackage.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.context.TextContext;
import samePackage.pages.StorePage;

import java.util.HashSet;

public class SearchSteps {
    private final WebDriver driver;
    public SearchSteps(TextContext context) {
        this.driver= context.driver;
    }

    @When("the user search product {string} from the search field")
    public void the_user_search_product_from_the_search_field(String product) {
       new StorePage(driver).searchProduct(product);
    }
    @Then("only products from {string} search text should be displayed")
    public void only_products_from_search_text_should_be_displayed(String message) {
        Assert.assertEquals(new StorePage(driver).checkSearch(),message,"Search functionality failed");
    }
}
