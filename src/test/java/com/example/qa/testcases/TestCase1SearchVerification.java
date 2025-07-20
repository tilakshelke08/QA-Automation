package com.example.qa.testcases;

import com.example.qa.components.Components_Amazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestCase1SearchVerification {
    private WebDriver driver;
    private Components_Amazon amazon;
    private String result;

    @BeforeClass
    public void setUp() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Program Files\\selenium\\driver\\chromedriver");
        driver = new ChromeDriver();
        amazon = new Components_Amazon(driver);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void testSearchAndValidateProducts() {
        try {
            amazon.searchForProduct("Laptop");
            amazon.validateProductDetails();
            amazon.openProductDetails(0);
            amazon.validateProductPage();
            result = "Passed";
        } catch (Exception e) {
            result = "Failed: " + e.getMessage();
        }
        logResult("TestCase1", result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void logResult(String testCase, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("testResults.txt", true))) {
            writer.write(testCase + "," + result);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
