package Intro;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2e {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //click on From arrow
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        //select Delhi in from
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        Thread.sleep(5000);
        //select chennai in to
        driver.findElement(By.xpath("(//a[contains(text(),' Chennai (MAA)')])[2]")).click();

        //select calendar
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

        //check other calendar tab should be disabled
        if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5"))
        {
            System.out.println("its disabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

        //click on senior citizen radio buutton
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        //open dropdown
        driver.findElement(By.xpath("//div[contains(@id,'divpaxinfo')]")).click();
        Thread.sleep(2000);
        //click on Adult 4 times
        for(int i =1;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        //click on done
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");

        //click on search
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();





    }


}
