package selenium.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SonyXperiaPage {
    private WebDriver driver;
    private By detailPagePriceElement = By.xpath("//span[@class='price']");

    public SonyXperiaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDetailPrice() {
        return driver.findElement(detailPagePriceElement).getText();
    }
}
