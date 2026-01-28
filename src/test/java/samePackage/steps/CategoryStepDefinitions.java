package samePackage.steps;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import samePackage.constants.EndPoints;
import samePackage.constants.MyClass;
import samePackage.context.TextContext;
import samePackage.factory.FactoryDriver;
import samePackage.pages.StorePage;

public class CategoryStepDefinitions {
    private final WebDriver driver;
    public CategoryStepDefinitions(TextContext context) {
        this.driver = context.driver;
    }

    @Given("the user is on the online shop homepage")
    public void the_user_is_on_the_online_shop_homepage() {
        new StorePage(driver).load(MyClass.STORE);

    }
    @When("the user selects {string} from the category dropdown")
    public void the_user_selects_accessories_from_the_category_dropdown(String category) {

        new StorePage(driver).selectCategory(category);

    }
    @Then("only products from {string} category should be displayed")
    public void only_products_from_accessories_category_should_be_displayed(String category) {

        String firstThreeChars = category.length() >= 3 ? category.substring(0, 3) : category;
        Assert.assertTrue(new  StorePage(driver).displayCategory(category).toLowerCase().contains(firstThreeChars)
        );
    }

}
