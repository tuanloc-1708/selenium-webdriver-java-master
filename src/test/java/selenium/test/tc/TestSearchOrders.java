package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import selenium.page.object.model.SearchOrders;

import java.io.File;

public class TestSearchOrders {
    @Test
    public void TestSearchOrders() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            //2. Login and export orders
            SearchOrders exportOrdersTest = new SearchOrders(driver);
            exportOrdersTest.loginBackend();

            exportOrdersTest.closeMessage();

            exportOrdersTest.clickSalesOrders();

            exportOrdersTest.clickSearch();

            Thread.sleep(3000);
            //3. Capture screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("Result.png"));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
