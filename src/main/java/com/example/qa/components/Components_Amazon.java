package com.example.qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Components_Amazon {

    private WebDriver driver;

    public Components_Amazon(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public WebElement getFirstProduct() {
        return driver.findElement(By.xpath("//*[@id=\"4e4e5ddf-879e-4276-978c-30f42d83bf47\"]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
    }

   // public WebElement getFirstProductPrice() {
     //   return driver.findElement(By.cssSelector("div.s-main-slot div[data-index='1'] span.a-price"));
    //}

    public WebElement getFirstProductRating() {
        return driver.findElement(By.cssSelector("a-icon a-icon-star a-star-4 cm-cr-review-stars-spacing-big"));
    }
}