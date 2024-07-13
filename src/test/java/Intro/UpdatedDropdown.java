package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//div[contains(@id,'divpaxinfo')]")).click();

        Thread.sleep(2000);

        //click on + 4times
        for(int i =1;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        //click on done
        driver.findElement(By.id("btnclosepaxoption")).click();

        //instead of for loop, we can use while also
        /*int i =1;
        while(i<5)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
*/




    }
}
