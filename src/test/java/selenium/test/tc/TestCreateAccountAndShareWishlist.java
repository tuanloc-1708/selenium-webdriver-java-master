package selenium.test.tc;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.AccountPage;

import java.time.Duration;

public class TestCreateAccountAndShareWishlist {
    @Test
    public void testCreateAccountAndShareWishlist() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            AccountPage accountPage = new AccountPage(driver);
            accountPage.clickMyAccountLink();
            accountPage.clickCreateAccountLink();

            //3. Click Create an Account link and fill New User information excluding the registered Email ID.
            accountPage.enterFirstName("John");
            accountPage.enterLastName("Doe");
            accountPage.enterEmail("johndoe4@example.com");
            accountPage.enterPassword("password123");
            accountPage.enterConfirmPassword("password123");

            //4. Click Register
            accountPage.clickRegisterButton();

            //5. Verify Registration is done. Expected account registration done.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
            String successMessage = driver.findElement(By.cssSelector(".success-msg")).getText();
            Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");

            //6. Go to TV menu
            accountPage.clickTvMenuLink();

            //7. Add product in your wish list - use product - LG LCD
            accountPage.clickAddToWishlistLink();

            //8. Click SHARE WISHLIST
            accountPage.clickShareWishlistButton();

            //9. In next page enter Email and a message and click SHARE WISHLIST
            accountPage.enterEmail("johndoe4@example.com");
            accountPage.enterMessage("Check out my wishlist!");
            accountPage.clickShareWishlistSubmitButton();

            //10.Check wishlist is shared. Expected wishlist shared successfully.
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
            String wishlistSharedMessage = driver.findElement(By.cssSelector(".success-msg")).getText();
            Assert.assertEquals(wishlistSharedMessage, "Your Wishlist has been shared.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
