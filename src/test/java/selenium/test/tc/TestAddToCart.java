package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.object.model.ShoppingCartPage;

public class TestAddToCart {
    @Test
    public void TestAddToCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on �MOBILE� menu
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickMobileLink();

            //3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            shoppingCartPage.clickAddToCartButton();

            //4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
            shoppingCartPage.changeQty("1000");
            shoppingCartPage.clickUpdateButton();
            String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";

            //5. Verify the error message
            String actualErrorMessage = shoppingCartPage.getErrorMessage();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

            //6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            shoppingCartPage.clickEmptyCartLink();
            String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";

            //7. Verify cart is empty
            String actualEmptyCartMessage = shoppingCartPage.getEmptyCartMessage();
            Assert.assertEquals(expectedEmptyCartMessage, actualEmptyCartMessage);

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
