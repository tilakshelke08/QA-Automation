package com.example.qa.testcases;

import com.example.qa.components.Components_Amazon;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestCase1SearchVerification {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        boolean testPassed = true;

        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in");

            Components_Amazon amazon = new Components_Amazon(driver);

            amazon.searchForProduct("Laptop");

            List<WebElement> results = amazon.getSearchResults();
            if (results.size() > 0) {
                System.out.println("Search results found: " + results.size());
                takeScreenshot(driver, "screenshots/test_case_1/search_results.png");
            } else {
                System.out.println("No search results found.");
                testPassed = false;
            }

            // Open first product
            amazon.clickFirstProduct();
            Thread.sleep(3000);

            // Switch to product tab if it opens in a new window
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            String title = amazon.getProductTitle();
            String price = amazon.getProductPrice();
            String availability = amazon.getAvailabilityStatus();

            System.out.println("Product Title: " + title);
            System.out.println("Product Price: " + price);
            System.out.println("Availability: " + availability);

            takeScreenshot(driver, "screenshots/test_case_1/product1_details.png");

            if (title.equals("Title Not Found") || price.equals("Price Not Found")) {
                testPassed = false;
            }

        } catch (Exception e) {
            System.out.println("Error in Test Case 1: " + e.getMessage());
            testPassed = false;
        } finally {
            driver.quit();
            updateTestResults(testPassed);
        }
    }

    public static void takeScreenshot(WebDriver driver, String path) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    public static void updateTestResults(boolean isPassed) {
        String status = isPassed ? "Passed" : "Failed";
        try (FileWriter writer = new FileWriter("testResults.txt", true)) {
            writer.write("Test Case 1: " + status + "\n");
        } catch (IOException e) {
            System.out.println("Unable to write to testResults.txt");
        }
    }
}