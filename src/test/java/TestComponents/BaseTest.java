package TestComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.pageobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;


    public WebDriver initilaizeDriver() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox")) {

            //firefox
        } else if (browserName.equalsIgnoreCase("edge")) {

            //edge
            WebDriver driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    //utility methods for  screenshot TC's
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") +"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source,destFile);
        return System.getProperty("user.dir") +"//reports//"+testCaseName+".png";

    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = initilaizeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
