package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {

    public static void main(String[] args) throws InterruptedException {



        /*
        --open the chrome browser
        --navigate the "http://eurotech.study/login"
        --enter email address "eurotech@gmail.com"
        --enter password "Test12345!"
        --Click login button
        --verify that url has changed
        --expectedUrl = "http://eurotech.study/dashboard"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        String email ="eurotech@gmail.com";
        String password ="Test12345!";

        //enter username
        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys(email);

        //second way
       // emailInput.sendKeys("eurotech@gmail.com");

        //enter password
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();




        //verify that URL has changed
        Thread.sleep(1000);
        String expectedUrl = "http://eurotech.study/dashboard";
        String actualUrl =driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.close();

    }
}
