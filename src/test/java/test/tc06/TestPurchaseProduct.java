package test.tc06;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.CartPage;

import java.time.Duration;

public class TestPurchaseProduct {
    @Test
    public void testPurchaseProduct() {

        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        CartPage purchasePage = new CartPage(driver);
        purchasePage.clickAccount();
        purchasePage.clickLogin();
        purchasePage.inputEmailAndPassword("johndoe3@example.com", "password123");
        purchasePage.clickLoginSubmit();
        purchasePage.clickMyWishlist();
        purchasePage.clickAddToCart();
        purchasePage.inputEstimate("Vietnam", "HCM", 700000);
        purchasePage.clickEstimate();
        purchasePage.clickShippingCostButton();
        boolean check = purchasePage.addShippingCost();
        Assert.assertTrue(check);
        purchasePage.clickProceedBtn();
        purchasePage.inputAddress("HCM HCM HCM");
        purchasePage.inputCity("Ha Noi");
        purchasePage.inputState();
        purchasePage.inputZip("700000");
        purchasePage.inputPhone("012345678");
        purchasePage.clickContinueBtn1();
        purchasePage.clickContinueBtn2();
        purchasePage.clickCheckMoneyOrder();
        purchasePage.clickContinueBtn3();
        purchasePage.clickPlaceOrder();


        driver.quit();

    }
}

