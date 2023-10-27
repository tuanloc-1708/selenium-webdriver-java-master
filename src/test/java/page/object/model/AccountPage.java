package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;

    By myAccountLink = By.linkText("MY ACCOUNT");
    By createAccountLink = By.linkText("CREATE AN ACCOUNT");
    By registerButton = By.xpath("//button[@title='Register']");
    By tvMenuLink = By.linkText("TV");
    By addToWishlistLink = By.xpath("//a[@title='LG LCD']//following::a[@class='link-wishlist']");
    By shareWishlistButton = By.name("save_and_share");
    By emailInput = By.id("email_address");
    By messageInput = By.id("message");
    By shareWishlistSubmitButton = By.xpath("//button[@title='Share Wishlist']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickTvMenuLink() {
        driver.findElement(tvMenuLink).click();
    }

    public void clickAddToWishlistLink() {
        driver.findElement(addToWishlistLink).click();
    }

    public void clickShareWishlistButton() {
        driver.findElement(shareWishlistButton).click();
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterMessage(String message) {
        WebElement messageElement = driver.findElement(messageInput);
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    public void clickShareWishlistSubmitButton() {
        driver.findElement(shareWishlistSubmitButton).click();
    }
}
