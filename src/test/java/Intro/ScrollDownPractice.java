package Intro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollDownPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");


       /*//other alternative to page down in window
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).perform();*/




    }
}
