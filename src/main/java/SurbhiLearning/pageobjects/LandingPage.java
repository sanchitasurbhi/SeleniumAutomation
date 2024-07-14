package SurbhiLearning.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SurbhiLearning.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   // WebElement userEmail = driver.findElement(By.id("userEmail"));

    //findby comes under page factory,so there is one method called initElements which you have to write first
    // so to get the life of driver , we initialize pagefactory in constructor above
    //UN
    @FindBy(id="userEmail")
    WebElement userEmail;
    //pwd
    @FindBy(css="input#userPassword")
    WebElement passwordEle;
    //login button
    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;




    public ProductCatalogue loginApplication(String email, String password)
    {
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;

    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();

    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }

}
