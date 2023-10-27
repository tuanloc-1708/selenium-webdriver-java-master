package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobilePage {
    WebDriver driver;

    By mobileLink = By.linkText("MOBILE");
    By sortByDropdown = By.cssSelector("select[title='Sort By']");
    By productNames = By.cssSelector(".product-name");
    private By sonyXperiaPriceElement = By.xpath("//span[contains(text(),'$100.00')]");
    private By sonyXperiaLink = By.xpath("//img[@id='product-collection-image-1']");

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void selectSortBy(String option) {
        new Select(driver.findElement(sortByDropdown)).selectByVisibleText(option);
    }

    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productNames);
        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }


    public String getListPrice() {
        return driver.findElement(sonyXperiaPriceElement).getText();
    }

    public void clickSonyXperiaLink() {
        driver.findElement(sonyXperiaLink).click();
    }


}

