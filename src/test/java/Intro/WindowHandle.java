package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();

        //highlight or click on image
        driver.findElement(By.cssSelector("a[target='_blank']")).click();

       Set<String> windows =  driver.getWindowHandles();
       Iterator<String> it  = windows.iterator();
       String parentid = it.next();
       String childid = it.next();
       driver.switchTo().window(childid);

        String emailID = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/p[2]")).getText();
        System.out.println(emailID);

        //String is -Please email us at mentor@rahulshettyacademy.com with below template to receive response
        //here split(" ") , space means it wil split into 1 single array character
        String splittedString = emailID.split("at")[1].trim().split(" ")[0];

        System.out.println(splittedString);
       //System.out.println(driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/p[1]")).getText());


        driver.switchTo().window(parentid);
        driver.findElement(By.id("username")).sendKeys(splittedString);


    }
}
