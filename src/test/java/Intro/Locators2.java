package Intro;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {

        String name = "surbhi";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();

        //Enter UN
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
        //Enter pwd
        driver.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys(password);
        //click on signin
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        //grab a text
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),' logged ')]")).getText());

        //use Assertion to validate
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),' logged ')]")).getText(),"You are successfully logged in.");

        //grab my name
        driver.findElement(By.xpath("//div[contains(@class,'login-container')]/h2")).getText();

        //Use assert ( instead of hardcode, your name , define one string at top.
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'login-container')]/h2")).getText(),"Hello " +name+",");

        //click on logout button
        driver.findElement(By.xpath("//button[contains(@class,'logout-btn')]")).click();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //click on forgot password
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
        Thread.sleep(2000);
        //click on reset login
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        //grab the text above
        String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();

        //String is - Please use temporary password 'rahulshettyacademy' to Login.
        String []passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        return password;
        //now this string is splitted into 2 parts.
        //0th index is - Please use temporary password
        //1st index is - rahulshettyacademy' to Login.

        //0th index is - rahulshettyacademy
        //1st index is - to Login.








    }
}
