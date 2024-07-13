package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import rahulshettyacademy.resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult iTestResult) {

       test = extent.createTest(iTestResult.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        test.log(Status.PASS,"Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //we want error message, that's why putting
        test.fail(iTestResult.getThrowable());

        //giving life to driver , so written this step
        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //screenshot, Attach to report
        String filePath = null;
        try {
            filePath = getScreenshot(iTestResult.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath,iTestResult.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        extent.flush();

    }
}
