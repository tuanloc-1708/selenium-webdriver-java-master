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
                //1. Goto http://live.techpanda.org/
                driver.get("http://live.techpanda.org/");

                //2. Click on �MOBILE� menu
                MobilePage mobilePage = new MobilePage(driver);
                mobilePage.clickMobileLink();

                //3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
                String listPrice = mobilePage.getListPrice();

                //4. Click on Sony Xperia mobile
                mobilePage.clickSonyXperiaLink();

                //5. Read the Sony Xperia mobile from detail page.
                SonyXperiaPage sonyXperiaPage = new SonyXperiaPage(driver);
                String detailPrice = sonyXperiaPage.getDetailPrice();

                //6. Compare Product value in list and details page should be equal ($100).
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
