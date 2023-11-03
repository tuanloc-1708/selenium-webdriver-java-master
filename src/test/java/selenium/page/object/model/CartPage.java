package selenium.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    By accountLogin = By.xpath("//span[@class='label'][normalize-space()='Account']");
    By loginLink = By.linkText("Log In");
    By emailBox = By.id("email");
    By passwordBox = By.id("pass");
    By loginBtn = By.id("send2");
    By myWishlist = By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']");
    By addToCart = By.xpath("//button[@title='Add to Cart']");
    By countryDropdown = By.id("country");
    By regionInput = By.id("region");
    By zipInput = By.id("postcode");
    By estimate = By.xpath("//span[contains(text(),'Estimate')]");
    By selectShippingCostButton = By.xpath("//input[@id='s_method_flatrate_flatrate']");
    By updateTotalBtn = By.xpath("//span[contains(text(),'Update Total')]");
    By proceedToCheckoutBtn = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");
    By inputAddress = By.name("billing[street][]");
    By inputCity = By.name("billing[city]");
    By zipInputChekout = By.id("billing:postcode");
    By stateDropdown = By.id("billing:region_id");
    By inputPhone = By.id("billing:telephone");
    By continueBtn1 = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");
    By continueBtn2 = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");
    By checkMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By continueBtn3 = By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]");
    By placeOrder = By.xpath("//span[contains(text(),'Place Order')]");
    By subTotal = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");
    By shippingCost = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)");
    By totalCost = By.cssSelector("strong span[class='price']");
    public  CartPage (WebDriver driver) {
        this.driver = driver;
    }

    //----------------------------------------------
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

    public void clickMyWishlist() {
        driver.findElement(myWishlist).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }

    public void inputEstimate(String country, String state, int zip) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(regionInput).sendKeys(state);
        driver.findElement(zipInput).sendKeys(String.valueOf(zip));
    }

    public void clickEstimate() {
        driver.findElement(estimate).click();
    }

    public void clickShippingCostButton() {
        driver.findElement(selectShippingCostButton).click();
    }

    public void clickProceedBtn() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void inputCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
    }

    public void inputZip(String zip){
        driver.findElement(zipInputChekout).sendKeys(zip);
    }

    public void inputState() {
        new Select(driver.findElement(stateDropdown)).selectByVisibleText("Ohio");
    }

    public void inputPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickContinueBtn1() {
        driver.findElement(continueBtn1).click();
    }

    public void clickContinueBtn2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn2));
        driver.findElement(continueBtn2).click();
    }

    public void clickCheckMoneyOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkMoneyOrder));
        driver.findElement(checkMoneyOrder).click();
    }

    public void clickContinueBtn3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn3));
        driver.findElement(continueBtn3).click();
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
        driver.findElement(placeOrder).click();
    }

    public boolean addShippingCost(){
        driver.findElement(selectShippingCostButton).click();
        driver.findElement(updateTotalBtn).click();
        String subtotalString = driver.findElement(subTotal).getText().replace(",", "").replace("$", "");
        String shippingString = driver.findElement(shippingCost).getText().replace(",", "").replace("$", "");
        String totalString = driver.findElement(totalCost).getText().replace(",", "").replace("$", "");
        double subtotal = Double.parseDouble(subtotalString);
        double shipping = Double.parseDouble(shippingString);
        double total = Double.parseDouble(totalString);
        return (total == shipping + subtotal);
    }
}
