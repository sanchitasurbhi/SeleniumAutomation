package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCartMutipleItemsWrapInDifferentMethod {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //implicit wait is applying globally
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //adding items into cart, created separate method and calling here in main
        addItems(driver,itemsNeeded);

        //click on image cart
        driver.findElement(By.cssSelector("div.container header:nth-child(1) div.container div.cart a.cart-icon:nth-child(5) > img:nth-child(1)")).click();
        //click on proceed to checkout
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        //Enter promocode
        driver.findElement(By.xpath("//input[contains(@class,'promoCode')]")).sendKeys("rahulshettyacademy");
        //click on Apply
        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

        //apply explicit wait on code Applied
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        //grab the text
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());






    }

    public static void addItems(WebDriver driver, String[] itemsNeeded)
    {

        //list of product items
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)
        {
            String[] name = products.get(i).getText().split("-");
            //to reomve whitespace in brocolli and other veggies
            String formattedName = name[0].trim();

            //convert array into arrayList for easy search
            //check whether name you extracted is present in ArrayList or not

            List itemNeededList = Arrays.asList(itemsNeeded);

            if(itemNeededList.contains(formattedName))
            {
                //click on Add to cart
                driver.findElements(By.xpath("//div[contains(@class,'product-action')]/button")).get(i).click();

            }

        }



    }


}
