package SurbhiLearning.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    //click on cart header
    @FindBy(css="button[routerlink='/dashboard/cart']")
    WebElement cartHeader;

    //click on orders
    @FindBy(css="button[routerlink*='myorders']")
    WebElement orderHeader;



    //by findby element to appear
    public void waitForElementToAppear(By findby) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

     }

     //pagefactory ele to appear
    public void waitForWebElementToAppear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));

    }

     //click on cart header
     public void goToCart() throws InterruptedException {
         Thread.sleep(3000);
         cartHeader.click();

     }

    public void goToOrder() throws InterruptedException {
        Thread.sleep(3000);
        orderHeader.click();

    }

     public void waitForElementToDisappear(WebElement ele)
     {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.invisibilityOf(ele));
     }


}
