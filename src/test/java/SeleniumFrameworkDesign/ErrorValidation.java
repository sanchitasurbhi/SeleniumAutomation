package SeleniumFrameworkDesign;

import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {

    @Test
    public void submitOrder() throws IOException, InterruptedException {

        String productName = "ZARA COAT 3";
        //login with incorrect UN or pwd
         landingPage.loginApplication("surbh.mvj@gmail.com", "1mj06cs122@CS");
         Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

        }

    @Test
    public void submitOrderErrorValidation() throws IOException, InterruptedException {

        String productName = "ZARA COAT 3";
        //login
        ProductCatalogue productCatalogue = landingPage.loginApplication("surbhi.mvj@gmail.com","1mj06cs122@CS");

        //Productcatalogue
        //ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        productCatalogue.goToCart();

        CartPage cartPage = new CartPage(driver);
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 32");
        junit.framework.Assert.assertFalse(match);


    }

}
