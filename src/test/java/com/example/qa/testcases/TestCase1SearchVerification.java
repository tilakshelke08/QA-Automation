package com.example.qa.testcases;

import com.example.qa.components.Components_Amazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase1SearchVerification {

    WebDriver driver;
    Components_Amazon amazon;
    String baseURL = "https://www.amazon.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("WebDriver.com.driver", "C:\\Program Files\\selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        amazon = new Components_Amazon(driver);
    }

    @Test
    public void testSearchAndProductValidation() {
        try {
            driver.get(baseURL);
            Thread.sleep(2000); // Wait for page to load

            // Search for "Laptop"
            amazon.getSearchBox().sendKeys("Laptop");
            amazon.getSearchButton().click();
            Thread.sleep(3000);

            // Validate title, price, and rating of the first product
            String productName = amazon.getFirstProduct().getText();
         //   String productPrice = amazon.getFirstProductPrice().getText();
            String productRating = amazon.getFirstProductRating().getText();

            Assert.assertFalse(productName.isEmpty());
          //  Assert.assertFalse(productPrice.isEmpty());
            Assert.assertTrue(productRating.contains("out of"));

            takeScreenshot("screenshots/test_case_1/search_results.png");

            // Click the product
            amazon.getFirstProduct().click();
            Thread.sleep(4000);

            // Switch to product tab
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            String pageTitle = driver.getTitle();
            Assert.assertTrue(pageTitle.contains("Laptop"));

            takeScreenshot("screenshots/test_case_1/product1_details.png");

            writeResult("Test Case 1: Passed");

        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot("screenshots/test_case_1/error.png");
            writeResult("Test Case 1: Failed");
            Assert.fail("Test failed due to exception.");
        }
    }

    public void takeScreenshot(String path) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get(path).getParent()); // Ensure directory exists
            Files.copy(src.toPath(), Paths.get(path));
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    public void writeResult(String result) {
        try (FileWriter writer = new FileWriter("testResults.txt", true)) {
            writer.write(result + "\n");
        } catch (Exception e) {
            System.out.println("Unable to write result: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}