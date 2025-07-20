package com.example.qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Components_Amazon {

    WebDriver driver;

    public Components_Amazon(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        try {
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();
            searchBox.sendKeys(productName);
            driver.findElement(By.id("nav-search-submit-button")).click();
            Thread.sleep(2000); // Let results load
        } catch (Exception e) {
            System.out.println("Error in searchForProduct: " + e.getMessage());
        }
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"));
    }

    public void clickFirstProduct() {
        try {
            List<WebElement> results = getSearchResults();
            if (!results.isEmpty()) {
                results.get(0).findElement(By.cssSelector("h2 a")).click();
            }
        } catch (Exception e) {
            System.out.println("Error in clickFirstProduct: " + e.getMessage());
        }
    }

    public String getProductTitle() {
        try {
            return driver.findElement(By.id("productTitle")).getText().trim();
        } catch (Exception e) {
            return "Title Not Found";
        }
    }

    public String getProductPrice() {
        try {
            WebElement priceWhole = driver.findElement(By.cssSelector("span.a-price span.a-offscreen"));
            return priceWhole.getText();
        } catch (Exception e) {
            return "Price Not Found";
        }
    }

    public String getAvailabilityStatus() {
        try {
            return driver.findElement(By.id("availability")).getText().trim();
        } catch (Exception e) {
            return "Availability Not Found";
        }
    }
}