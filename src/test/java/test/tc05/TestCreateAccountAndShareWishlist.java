package test.tc05;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            driver.get("http://live.techpanda.org/");

            AccountPage accountPage = new AccountPage(driver);
            accountPage.clickMyAccountLink();
            accountPage.clickCreateAccountLink();

            // Fill in new user information here...
            WebElement firstNameInput = driver.findElement(By.id("firstname"));
            firstNameInput.sendKeys("John");

            WebElement lastNameInput = driver.findElement(By.id("lastname"));
            lastNameInput.sendKeys("Doe");

            WebElement emailInput = driver.findElement(By.id("email_address"));
            emailInput.sendKeys("johndoe@example.com");

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("password123");

            WebElement confirmPasswordInput = driver.findElement(By.id("confirmation"));
            confirmPasswordInput.sendKeys("password123");
            accountPage.clickRegisterButton();

            // Verify registration is done...
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
            String successMessage = driver.findElement(By.cssSelector(".success-msg")).getText();
            Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");

            accountPage.clickTvMenuLink();
            accountPage.clickAddToWishlistLink();

            accountPage.clickShareWishlistButton();

            accountPage.enterEmail("johndoe@example.com");
            accountPage.enterMessage("Check out my wishlist!");
            accountPage.clickShareWishlistSubmitButton();

            // Check wishlist is shared...
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
