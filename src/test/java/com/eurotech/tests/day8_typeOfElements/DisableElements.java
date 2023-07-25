package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {

    @Test
    public void test1() throws InterruptedException {

        /*
        --navigate https://the-internet.herokuapp.com/dynamic_controls
        --verify that input box element is disabled
        --click enable button
        --verify that  inbox element is enabled
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        //verify that input box element is disabled
        Assert.assertFalse(inputBox.isEnabled(),"Inbox is ENABLED");



        //click enable button
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        enableButton.click();

        Thread.sleep(5000);
        //verify that  inbox element is enabled
        Assert.assertTrue(inputBox.isEnabled(),"Input Box is DISABLED");

        inputBox.sendKeys("Eurotech was here");



        Thread.sleep(2000);
        driver.close();
    }
}
