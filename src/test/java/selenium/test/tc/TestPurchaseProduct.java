package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.object.model.CartPage;

public class TestPurchaseProduct {
    @Test
    public void testPurchaseProduct() {

        WebDriver driver = driverFactory.getChromeDriver();

        //1. Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //2. Click on my account link
        CartPage purchasePage = new CartPage(driver);
        purchasePage.clickAccount();
        purchasePage.clickLogin();

        //3. Login in application using previously created credential
        purchasePage.inputEmailAndPassword("johndoe3@example.com", "password123");
        purchasePage.clickLoginSubmit();

        //4. Click on MY WISHLIST link
        purchasePage.clickMyWishlist();

        //5. In next page, Click ADD TO CART link
        purchasePage.clickAddToCart();

        //6. Enter general shipping country, state/province and zip for the shipping cost estimate
        purchasePage.inputEstimate("Vietnam", "HCM", 700000);

        //7. Click Estimate
        purchasePage.clickEstimate();

        //8. Verify Shipping cost generated
        purchasePage.clickShippingCostButton();

        //9. Select Shipping Cost, Update Total
        boolean check = purchasePage.addShippingCost();
        Assert.assertTrue(check);
        purchasePage.clickProceedBtn();
        purchasePage.inputAddress("HCM HCM HCM");
        purchasePage.inputCity("Ha Noi");
        purchasePage.inputState();
        purchasePage.inputZip("700000");
        purchasePage.inputPhone("012345678");

        //10. Verify shipping cost is added to total, 12a. Enter Billing Information, and click Continue,
        //12b. Enter Shipping Information, and click Continue & 13. In Shipping Method, Click Continue
        //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
        purchasePage.clickContinueBtn1();
        purchasePage.clickContinueBtn2();
        purchasePage.clickCheckMoneyOrder();
        purchasePage.clickContinueBtn3();

        //15. Click 'PLACE ORDER' button & 16. Verify Oder is generated. Note the order number
        purchasePage.clickPlaceOrder();

        driver.quit();

    }
}

