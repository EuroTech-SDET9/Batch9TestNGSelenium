package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");


        WebElement nameInput = driver.findElement(By.tagName("input"));
        nameInput.sendKeys("Teacher");

        //Selenium starts looking for the element from first line
        //After finds the element, it clicks or writes etc
        ///Then selenium go back first line again and starts looking for from there.

        WebElement emailInput = driver.findElement(By.tagName("input"));
        nameInput.clear();
        emailInput.sendKeys("eurotech@gmail.com");

        Thread.sleep(1000);
        driver.close();
    }
}
