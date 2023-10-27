package test.tc04;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.CompareProductsPage;

public class TestCompareProducts {
    @Test
    public void testCompareProducts() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on �MOBILE� menu
            CompareProductsPage compareProductsPage = new CompareProductsPage(driver);
            compareProductsPage.clickMobileLink();

            //3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
            compareProductsPage.clickCompareSonyXperiaButton();
            compareProductsPage.clickCompareIphoneButton();

            //4. Click on �COMPARE� button. A popup window opens
            compareProductsPage.clickCompareButton();

            //5. Verify the pop-up window and check that the products are reflected in it
            //Heading "COMPARE PRODUCTS" with selected products in it.
            String expectedHeader = "COMPARE PRODUCTS";
            String actualHeader = compareProductsPage.getCompareProductsHeader();
            Assert.assertEquals(expectedHeader, actualHeader);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6. Close the Popup Windows
            driver.quit();
        }
    }
}
