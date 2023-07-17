package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();

        //enter username
        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("Hello World");

        //2 - getAttribute() --> second way of getting text especially input box
        System.out.println("emailInput.getText() = " + emailInput.getText());
        System.out.println("Email Area = " + emailInput.getAttribute("value"));

        System.out.println("emailInput.getAttribute(\"placeholder\") = " + emailInput.getAttribute("placeholder"));
        System.out.println("emailInput.getAttribute(\"id\") = " + emailInput.getAttribute("id"));
        System.out.println("emailInput.getAttribute(\"type\") = " + emailInput.getAttribute("type"));



        driver.close();
    }
}
