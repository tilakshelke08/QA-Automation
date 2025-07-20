package com.example.qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Components_Amazon {
    private WebDriver driver;

    public Components_Amazon(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String product) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void validateProductDetails() {
        List<WebElement> products = driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));
        for (int i = 0; i < Math.min(products.size(), 3); i++) {
            WebElement product = products.get(i);
            String title = product.findElement(By.cssSelector("h2")).getText();
            String price = product.findElement(By.cssSelector(".a-price .a-offscreen")).getText();
            String rating = product.findElement(By.cssSelector(".a-icon-alt")).getText();

            System.out.println("Product " + (i + 1) + ": Title: " + title + ", Price: " + price + ", Rating: " + rating);
        }
    }

    public void openProductDetails(int index) {
        List<WebElement> products = driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));
        products.get(index).click();
    }

    public void validateProductPage() {
        String title = driver.findElement(By.id("productTitle")).getText();
        String price = driver.findElement(By.id("priceblock_ourprice")).getText();
        System.out.println("Product Details - Title: " + title + ", Price: " + price);
    }
}
