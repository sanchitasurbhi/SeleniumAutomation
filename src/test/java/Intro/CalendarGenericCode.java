package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarGenericCode {

    public static void main(String[] args) {

        String monthNumber ="12";
        String date ="15";
        String year ="2027";


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on calendar edit box
        driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();

        //click on july 2024
        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();

        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();

        //click on 2027
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();

       //click on month
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();

        //select date
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();






















    }
}
