package com.example.qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Components_Apple {
    private WebDriver driver;

    public Components_Apple(WebDriver driver) {
        this.driver = driver;
    }

    public void validateFormFields() {
        // Check if the form fields are visible
        boolean isEmailFieldVisible = driver.findElement(By.id("email")).isDisplayed();
        boolean isPasswordFieldVisible = driver.findElement(By.id("password")).isDisplayed();
        boolean isConfirmPasswordFieldVisible = driver.findElement(By.id("confirmPassword")).isDisplayed();

        System.out.println("Email Field Visible: " + isEmailFieldVisible);
        System.out.println("Password Field Visible: " + isPasswordFieldVisible);
        System.out.println("Confirm Password Field Visible: " + isConfirmPasswordFieldVisible);
    }

    public void submitBlankForm() {
        driver.findElement(By.id("submit")).click();
        String errorMessage = driver.findElement(By.cssSelector(".error-message")).getText();
        System.out.println("Error Message for Blank Form: " + errorMessage);
    }

    public void validateEmailFormat(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submit")).click();
        String errorMessage = driver.findElement(By.cssSelector(".error-message")).getText();
        System.out.println("Error Message for Invalid Email: " + errorMessage);
    }

    public void validatePasswordRequirements(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmPassword")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        String errorMessage = driver.findElement(By.cssSelector(".error-message")).getText();
        System.out.println("Error Message for Weak Password: " + errorMessage);
    }

    public void validatePasswordMismatch(String password, String confirmPassword) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("submit")).click();
        String errorMessage = driver.findElement(By.cssSelector(".error-message")).getText();
        System.out.println("Error Message for Password Mismatch: " + errorMessage);
    }
}
