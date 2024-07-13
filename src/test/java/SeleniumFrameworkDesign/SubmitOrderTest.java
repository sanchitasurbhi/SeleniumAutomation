package SeleniumFrameworkDesign;

import TestComponents.BaseTest;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    String productName = "ZARA COAT 3";
    String email = "surbhi.mvj@gmail.com";
    String password = "1mj06cs122@CS";

    @Test()
    public void submitOrder() throws IOException, InterruptedException {


        //login
        ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);

        //Productcatalogue
        //ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        productCatalogue.goToCart();

        CartPage cartPage = new CartPage(driver);
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        cartPage.goTocheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCountry("India");
        Thread.sleep(3000);
        checkoutPage.placeOrder();

        Thread.sleep(3000);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() throws InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication("surbhi.mvj@gmail.com", "1mj06cs122@CS");
        productCatalogue.goToOrder();

        OrderPage orderPage = new OrderPage(driver);
        Boolean match = orderPage.VerifyOrderDisplay(productName);
        Assert.assertTrue(match);

    }






}
