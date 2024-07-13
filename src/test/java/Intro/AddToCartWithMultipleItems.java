package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddToCartWithMultipleItems {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

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
