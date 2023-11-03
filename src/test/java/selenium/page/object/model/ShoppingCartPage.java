package selenium.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    WebDriver driver;

     By mobileLink = By.linkText("MOBILE");
    By addToCartButton = By.xpath("//a[@title='Sony Xperia']//following::button[@title='Add to Cart']");
     By qtyInput = By.cssSelector("input[title='Qty']");
     By updateButton = By.cssSelector("button[title='Update']");
     By errorMessage = By.cssSelector(".error-msg");
    By emptyCartLink = By.cssSelector("a[title='Empty Cart']");
     By emptyCartMessage = By.cssSelector(".cart-empty");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void changeQty(String qty) {
        WebElement qtyElement = driver.findElement(qtyInput);
        qtyElement.clear();
        qtyElement.sendKeys(qty);
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickEmptyCartLink() {
        driver.findElement(emptyCartLink).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }
}
