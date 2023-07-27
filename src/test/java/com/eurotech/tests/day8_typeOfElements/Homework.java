package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework {

    /*

        --navigate https://demo.aspnetawesome.com/
        --verify that vegetable is selected
        --verify that legume is NOT SELECTED
        --click legume
        --Verify that vegetable is NOT SELECTED
         --verify that legume is selected
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");

//        verify that vegetable is selected
//        verify that legume is NOT SELECTED

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']//preceding-sibling::input"));
//        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/..//input"));
        Assert.assertTrue(vegetablesRadio.isSelected(), "Verifying vegetables radio button is selected");
        Assert.assertFalse(legumesRadio.isSelected(), "Verifying legumes radio button is not selected");

        WebElement legumes = driver.findElement(By.xpath("//div[text()='Legumes']/..//input/../div[1]"));
        legumes.click();

        Thread.sleep(1000);
        Assert.assertTrue(legumesRadio.isSelected(), "Legumes radio button is not selected");
        Assert.assertFalse(vegetablesRadio.isSelected(), "Vegetables radio button is selected");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
