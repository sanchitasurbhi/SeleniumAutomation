package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //Enter UN pwd and click on sign in
        driver.findElement(By.xpath("//input[contains(@id,'inputUsername')]")).sendKeys("rahul");
        driver.findElement(By.xpath("//input[contains(@name,'inputPassword')]")).sendKeys("123");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();


        //capture error message
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        //click on forgot password
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();

        //enter Name
        driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("John");

        //enter email
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com");

        //enter phone Number
        driver.findElement(By.xpath("//form//input[3]")).sendKeys("8217564613");

        //click on reset login
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        //grab the text above
        System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());

        //click on got to login
        driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();

        Thread.sleep(2000);
        //Enter UN
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Rahul");

        //Enter pwd
        driver.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys("rahulshettyacademy");

        //click on signin
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

    }
}
