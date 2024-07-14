package SurbhiLearning.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SurbhiLearning.AbstractComponent.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css=".cartSection h3")
    private List<WebElement> productTitles;

    @FindBy(css=".totalRow button")
    WebElement checkoutEle;


    public Boolean VerifyProductDisplay(String productName)
    {
        Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public void goTocheckout()
    {
        checkoutEle.click();

    }





}
