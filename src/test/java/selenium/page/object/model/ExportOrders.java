package selenium.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ExportOrders {
    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("login");
    By loginButton = By.xpath("//input[@value='Login']");

    By closeButton = By.xpath("//span[normalize-space()='close']");
    By salesLink = By.xpath("//span[normalize-space()='Sales']");
    By ordersLink = By.xpath("//span[normalize-space()='Orders']");
    By exportToDropdown = By.xpath("//select[@id='sales_order_grid_export']");
    By exportButton = By.xpath("//span[contains(text(),'Export')]");

    public ExportOrders(WebDriver driver) {
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

    public void clickExportCsv() {
        new Select(driver.findElement(exportToDropdown)).selectByVisibleText("CSV");
        driver.findElement(exportButton).click();
    }
}
