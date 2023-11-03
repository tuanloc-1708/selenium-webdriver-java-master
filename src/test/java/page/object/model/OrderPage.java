package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;

    By accountLogin = By.xpath("//span[@class='label'][normalize-space()='Account']");
    By loginLink = By.linkText("Log In");
    By emailBox = By.id("email");
    By passwordBox = By.id("pass");
    By loginBtn = By.id("send2");
    By viewMyOrderLink = By.xpath("//a[normalize-space()='My Orders']");
    By viewOrderLink = By.xpath("//a[normalize-space()='View Order']");

    By printOrderLink = By.xpath("//a[@class='link-print']");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //---------------------
    public void clickAccount() {
        driver.findElement(accountLogin).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void inputEmailAndPassword(String email, String password) {
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickLoginSubmit() {
        driver.findElement(loginBtn).click();
    }

    public void clickMyOrders(){driver.findElement(viewMyOrderLink).click();}

    public void clickViewOrder(){driver.findElement(viewOrderLink).click();}

    public void clickPrintOrder(){driver.findElement(printOrderLink).click();}
}
