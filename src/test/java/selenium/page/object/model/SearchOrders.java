package selenium.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchOrders {
    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("login");
    By loginButton = By.xpath("//input[@value='Login']");

    By closeButton = By.xpath("//span[normalize-space()='close']");
    By salesLink = By.xpath("//span[normalize-space()='Sales']");
    By ordersLink = By.xpath("//span[normalize-space()='Orders']");
    By orderIdField = By.xpath("//input[@id='sales_order_grid_filter_real_order_id']");
    By fromDateField = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");
    By toDateField = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");

    By searchButton = By.xpath("//span[contains(text(),'Search')]");
    public SearchOrders(WebDriver driver) {
        this.driver = driver;
    }

    public void closeMessage() {
        driver.findElement(closeButton).click();
    }

    public void loginBackend() {
        driver.findElement(usernameField).sendKeys("user01");
        driver.findElement(passwordField).sendKeys("guru99com");
        driver.findElement(loginButton).click();
    }

    public void clickSalesOrders() {
        driver.findElement(salesLink).click();
        driver.findElement(ordersLink).click();
    }

    public void clickSearch() {
        driver.findElement(orderIdField).sendKeys("100021294");
        driver.findElement(fromDateField).sendKeys("11/09/2023");
        driver.findElement(toDateField).sendKeys("11/09/2023");
        driver.findElement(searchButton).click();
    }
}
