package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponent.AbstractComponent;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //findby comes under page factory,so there is one method called initElements which you have to write first
    // so to get the life of driver , we initialize pagefactory in constructor above

    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By productsby = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    public List<WebElement> getProductList()
    {
        waitForElementToAppear(productsby);
        return products;
    }

    //get the product ZARA COAT 3
    public WebElement getProductByName(String productName)
    {
        WebElement prod = getProductList().stream().filter(S -> S.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    //click on add to cart product zara coat 3
    public void addProductToCart(String productName)
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);

    }


}
