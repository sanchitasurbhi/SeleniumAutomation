package SeleniumFrameworkDesign;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageobjects.LandingPage;

import java.time.Duration;
import java.util.List;

public class Standalone {
    public static void main(String[] args) throws InterruptedException {


        String productName="ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client/");
        //login
        driver.findElement(By.id("userEmail")).sendKeys("surbhi.mvj@gmail.com");

        LandingPage landingPage = new LandingPage(driver);

        driver.findElement(By.cssSelector("input#userPassword")).sendKeys("1mj06cs122@CS");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //add to cart scenario



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream().filter(S->S.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        //click on add to cart
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //validate added to cart, adding because after few seconds elements get invisible

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        //click on cart
        driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

        //validate whetr items are added
        String zara = driver.findElement(By.cssSelector(".cartSection h3")).getText();
        Assert.assertEquals(zara,"ZARA COAT 3");

        //click on checkout
        driver.findElement(By.cssSelector(".totalRow button")).click();

        //click on select Country, though there is straightforward concept to click, but here use action class
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();

        //it will wait until the popup opens
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        //click on country
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

        Thread.sleep(3000);
        //click on place order
        a.moveToElement(driver.findElement(By.xpath("//a[contains(@class,'btnn action__submit ng-star-inserted')]"))).click().build().perform();
        //get thankyou message
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

       // driver.close();











    }
}
