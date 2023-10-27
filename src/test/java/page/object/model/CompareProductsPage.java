package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompareProductsPage {
    WebDriver driver;

    By mobileLink = By.linkText("MOBILE");
    By compareSonyXperiaButton = By.xpath("//a[@title='Sony Xperia']//following::a[@class='link-compare']");
    By compareIphoneButton = By.xpath("//a[@title='IPhone']//following::a[@class='link-compare']");
    By compareButton = By.cssSelector("button[title='Compare']");
    By compareProductsHeader = By.cssSelector(".page-title title");

    public CompareProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void clickCompareSonyXperiaButton() {
        driver.findElement(compareSonyXperiaButton).click();
    }

    public void clickCompareIphoneButton() {
        driver.findElement(compareIphoneButton).click();
    }

    public void clickCompareButton() {
        driver.findElement(compareButton).click();
    }

        public String getCompareProductsHeader() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(compareProductsHeader));
            return driver.findElement(compareProductsHeader).getText();
        }
}
