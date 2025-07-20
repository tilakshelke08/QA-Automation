package com.example.qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Components_Amazon {
    private WebDriver driver;

    public Components_Amazon(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String product) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void validateProductDetails(int index) {
        // Logic to validate product details
        // This is a placeholder for actual validation logic
    }
}
