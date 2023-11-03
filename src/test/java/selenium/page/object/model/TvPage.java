package selenium.page.object.model;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TvPage {
    WebDriver driver;

    By tvLink = By.linkText("TV");
    By sortByDropdown = By.cssSelector("select[title='Sort By']");
    By productNames = By.cssSelector(".product-name");

    public TvPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTVLink() {
        driver.findElement(tvLink).click();
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
}

