package samePackage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class StorePage extends BasePage{

//  @FindBy(css = "button.button[type='submit']") private By filterButton;
//    @FindBy(css = "button.button[type='submit']") private By productPrices;

    public StorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".dropdown_product_cat")private WebElement categoryDropdown;
        public void selectCategory(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown)).click();
        Select select = new Select(categoryDropdown);
        select.selectByValue(category);
    }
    public String displayCategory(String category){
      By categoryProducts = By.cssSelector("h1.woocommerce-products-header__title.page-title");
        WebElement text= wait.until(visibilityOfElementLocated(categoryProducts));
        System.out.println(text.getText());
        return text.getText();
    }
    public void searchProduct(String text){
        driver.findElement(By.cssSelector("[type='search']")).sendKeys(text);
        driver.findElement(By.cssSelector("[type='submit']")).click();


    }
    public String checkSearch(){
        WebElement text1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));
        return text1.getText();
    }

    public void setPriceRange(Integer minV, Integer maxV) {
            By filterButton=By.cssSelector("button.button[type='submit']");
         By formSlider= By.cssSelector(".price_slider_wrapper");
        WebElement priceSlider = driver.findElement(formSlider);
         wait.until(ExpectedConditions.visibilityOf(priceSlider));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Set min and max price using JS
        js.executeScript("arguments[0].scrollIntoView({block:'center'});" +
                "document.getElementById('min_price').value=arguments[1];" +
                "document.getElementById('max_price').value=arguments[2];",priceSlider, minV, maxV);

        driver.findElement(filterButton).click();


    }


    public void priceRangeDisplayer(Integer minV,Integer maxV){
        By productPrices=By.cssSelector(".price");
        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String text = element.getText();
            String[] numbers = text.replaceAll("[^0-9. ]", "").trim().split("\\s+");
            String clean = numbers.length >= 2 ? numbers[1] : numbers[0];
            double price = Double.parseDouble(clean);
            prices.add(price);


            Assert.assertTrue(price >= minV && price <= maxV,
                    "Price out of range: " + price);

        }
        double[] priceArray = prices.stream().mapToDouble(Double::doubleValue).toArray();
        System.out.println("Prices found before sorting: " + Arrays.toString(priceArray));
        Arrays.sort(priceArray);
        System.out.println("Prices found: " + Arrays.toString(priceArray));
 }

}
