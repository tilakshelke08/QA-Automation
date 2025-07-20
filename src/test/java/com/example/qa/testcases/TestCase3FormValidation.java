package com.example.qa.testcases;

import com.example.qa.components.Components_Apple;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestCase3FormValidation {
    private WebDriver driver;
    private Components_Apple apple;
    private String result;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        apple = new Components_Apple(driver);
        driver.get("https://account.apple.com/account");
    }

    @Test
    public void testFormValidation() {
        try {
            apple.validateFormFields();
            apple.submitBlankForm();
            apple.validateEmailFormat("invalid-email");
            apple.validatePasswordRequirements("123");
            apple.validatePasswordMismatch("password123", "password456");
            result = "Passed"; // Change this based on actual validation
        } catch (Exception e) {
            result = "Failed: " + e.getMessage();
        }
        logResult("TestCase3", result);
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
