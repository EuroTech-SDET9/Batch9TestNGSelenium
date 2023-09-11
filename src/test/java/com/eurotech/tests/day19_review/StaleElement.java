package com.eurotech.tests.day19_review;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {


    @Test
    public void staleElement(){

        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test12234");


        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

      //  emailInput.sendKeys("eurotech@gmail.com");
        passwordInput.sendKeys("fjdjfhkjsdhfkjds");

    }

    @Test
    public void staleElementFixing() {
        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test12234");


        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        try {
            emailInput.sendKeys("eurotech@gmail.com");
        }catch (StaleElementReferenceException e){
            emailInput=driver.findElement(By.name("email"));
            emailInput.sendKeys("eurotech@gmail.com");
            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("Test12345");
        }

    }
}
