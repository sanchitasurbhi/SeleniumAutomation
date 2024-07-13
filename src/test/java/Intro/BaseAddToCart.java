package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseAddToCart {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //list of product items
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)
        {
          String name =  products.get(i).getText();

          if(name.contains("Cucumber"))
          {
              //click on Add to cart
              driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
              break;
          }

        }


    }
}
