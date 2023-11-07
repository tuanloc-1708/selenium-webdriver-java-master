package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.object.model.ExportOrders;

public class TestExportOrders {
    @Test
    public void TestExportOrders() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            //2. Login and export orders
            ExportOrders exportOrdersTest = new ExportOrders(driver);
            exportOrdersTest.loginBackend();

            exportOrdersTest.closeMessage();

            exportOrdersTest.clickSalesOrders();

            exportOrdersTest.clickExportCsv();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
