package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.object.model.CartPage;
import page.object.model.OrderPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TestSaveOrderAsPdf {
    @Test
    public void verifySaveOrderAsPdf() throws InterruptedException, AWTException {
        WebDriver driver = driverFactory.getChromeDriver();
        //1. Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //2. Click on My Account link
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickAccount();
        orderPage.clickLogin();

        //3. Login in application using previously created credential
        orderPage.inputEmailAndPassword("johndoe1@example.com", "password123");
        orderPage.clickLoginSubmit();

        //4. Click on 'My Orders'
        orderPage.clickMyOrders();

        //5. Click on 'View Order'
        orderPage.clickViewOrder();
        Thread.sleep(5000);

        //6. Click on 'Print Order' link
        orderPage.clickPrintOrder();
        Thread.sleep(5000);

        driver.quit();
    }

}
