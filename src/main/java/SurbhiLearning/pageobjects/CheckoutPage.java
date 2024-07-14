package SurbhiLearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SurbhiLearning.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".action_submit")
    WebElement submit;

    @FindBy(css="input[placeholder='Select Country']")
    WebElement country;

    @FindBy(css=".ta-item:nth-of-type(2)")
    WebElement selectCountry;

    @FindBy(xpath="//a[contains(@class,'btnn action__submit ng-star-inserted')]")
    WebElement submitOrder;


    By results = By.cssSelector(".ta-results");

    //choose dropdown option
    public void selectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public void placeOrder() throws InterruptedException {
        Thread.sleep(5000);
        Actions a = new Actions(driver);
        a.moveToElement(submitOrder).click().build().perform();

    }











}
