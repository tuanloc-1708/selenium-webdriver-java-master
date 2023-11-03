package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.object.model.ReorderPage;

@Test
public class TestReorderPage {
    public void testReorderPage() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();

        //1. Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //2. Click on my account link
        ReorderPage reOrderPage = new ReorderPage(driver);
        reOrderPage.clickAccount();
        reOrderPage.clickLogin();
            reOrderPage.inputEmailAndPassword("johndoe1@example.com", "password123");
        reOrderPage.clickLoginSubmit();

        //3. Login in application using previously created credential
        reOrderPage.clickReorderBtn();
        reOrderPage.inputQuantity(100);

        //4. Click on 'REORDER' link , change QTY & click Update
        reOrderPage.updateQuantity();

        //5. Verify Grand Total is changed
        boolean check = reOrderPage.addShippingCost();
        Assert.assertTrue(check);

        //6. Complete Billing & Shipping Information
        reOrderPage.clickEstimate();
        reOrderPage.clickProceedBtn();
        reOrderPage.clickContinueBtn1();
        reOrderPage.clickContinueBtn2();
        reOrderPage.clickCheckMoneyOrder();
        reOrderPage.clickContinueBtn3();
        reOrderPage.clickPlaceOrder();
        Thread.sleep(5000);
        //7. Verify order is generated and note the order number

        driver.quit();
    }
}
