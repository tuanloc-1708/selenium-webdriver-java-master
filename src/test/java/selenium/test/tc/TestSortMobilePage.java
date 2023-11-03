package selenium.test.tc;

import driver.driverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import selenium.page.object.model.MobilePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Test
public class TestSortMobilePage {
    public static void TestSortingByName() {
        WebDriver driver = driverFactory.getChromeDriver();
        MobilePage mobilePage = new MobilePage(driver);

        try {
            // Step 1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // Step 2: Verify Title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Step 3: Click on -> MOBILE -> menu
            mobilePage.clickMobileLink();

            // Step 4: In the list of all mobile, select SORT BY -> dropdown as name
            mobilePage.selectSortBy("Name");

            // Step 5: Verify all products are sorted by name
            List<String> productNames = mobilePage.getProductNames();

            List<String> sortedProductNames = new ArrayList<>(productNames);
            Collections.sort(sortedProductNames);

            if (productNames.equals(sortedProductNames)) {
                System.out.println("Products are sorted by name");
            } else {
                System.out.println("Products are not sorted by name");
            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit browser session
            driver.quit();
        }
    }
}
