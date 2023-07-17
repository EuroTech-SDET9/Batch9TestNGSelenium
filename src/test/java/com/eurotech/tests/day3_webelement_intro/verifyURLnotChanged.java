package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) throws InterruptedException {

        /*
        --open the chrome browser
        --navigate the "http://eurotech.study/login"
        --Click login button
        --verify that url did not change
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        //click login button

        String expectedUrl="http://eurotech.study/login";


        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        //this is milestone moment of selenium

        loginBtn.click();

        //get actual URL
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.close();

    }
}
