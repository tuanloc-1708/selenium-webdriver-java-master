    package test.tc02;

    import driver.driverFactory;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.testng.annotations.Test;
    import page.object.model.MobilePage;
    import page.object.model.SonyXperiaPage;

    @Test
    public class TestPriceSonyXperia {
        public static void TestPriceSonyXperia() {
            WebDriver driver = driverFactory.getChromeDriver();

            try {
                driver.get("http://live.techpanda.org/");

                MobilePage mobilePage = new MobilePage(driver);
                mobilePage.clickMobileLink();

                String listPrice = mobilePage.getListPrice();

                mobilePage.clickSonyXperiaLink();

                SonyXperiaPage sonyXperiaPage = new SonyXperiaPage(driver);
                String detailPrice = sonyXperiaPage.getDetailPrice();

                if (listPrice.equals(detailPrice)) {
                    System.out.println("The product price on the list and details page are equal.");
                } else {
                    System.out.println("The product price on the list and details page are not equal.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    }
