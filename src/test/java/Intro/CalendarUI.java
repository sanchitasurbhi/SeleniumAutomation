package Intro;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Thread.sleep(5000);
        //click calendar icon
        driver.findElement(By.xpath("(//button[contains(@class,'ui-datepicker-trigger')])[1]")).click();
        //click on date
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

        //Before clicking on round trip, validate whethr it is enabled or disabled
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
        //driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();
        //click on round Trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //validate whethr Return date is enabled or disabled, after selecting round trip it should be enabled
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
       // driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();

        if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("1"))
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }







    }
}
