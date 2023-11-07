package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.object.model.IphonePage;

public class TestAddMobileToCart {
    @Test
    public void testAddMobileToCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
        driver.get("http://live.techpanda.org/");

        IphonePage iphonePage = new IphonePage(driver);
        iphonePage.clickMobileLink();
        iphonePage.clickAddCart();
        iphonePage.enterCouponCode("GURU50");
        iphonePage.clickApplyDiscount();
        boolean check = iphonePage.verifyDiscountGenerated();
        Assert.assertTrue(check);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        driver.quit();
    }
    }

}
