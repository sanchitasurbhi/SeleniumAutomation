package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //li[class='ui-menu-item'] a
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> allOptions= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option:allOptions)
        {
            if(option.getText().equalsIgnoreCase("India"));
            {
                Thread.sleep(5000);
                option.click();

            }
        }

    }
}
