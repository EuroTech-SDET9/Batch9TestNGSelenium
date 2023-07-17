package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

         /*
        --open the chrome browser
        --navigate the "http://eurotech.study/login"
        --enter email address "eurotech@gmail.com"
        --enter password "Test12345!"
        --Click login button
        --verify that confirmation message is "Welcome Teacher"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();

        //enter username
        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");

        //enter password
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");

        //click login button
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);

        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));
        System.out.println("welcomeMessage = " + welcomeMessage);

        //we have two ways to get text from web pages
        //1 - getText() -->it will work %99 and it will return String
        //2 - getAttribute() --> ....
        String actualMessage = welcomeMessage.getText();
        System.out.println("actualText = " + actualMessage);

        String expectedMessage ="Welcome Teacher";
        if (expectedMessage.equals(actualMessage)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        Thread.sleep(1000);
        driver.close();


    }
}
