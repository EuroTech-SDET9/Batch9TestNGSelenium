package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {

        /*
        --Navigate https://rahulshettyacademy.com/AutomationPractice/
        --verify that option1 is unselected
        --Click option1
        ==verify that option1 is selected
        --Click option2
        --verify that option2 is selected
        --verify that option3 is unselected
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement option1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
        Assert.assertFalse(option1.isSelected(),"Option1 is SELECTED");

        option1.click();

        Assert.assertTrue(option1.isSelected(),"Option1 is UNSELECTED");
        WebElement option2 = driver.findElement(By.cssSelector("#checkBoxOption2"));
        option2.click();



        Assert.assertTrue(option2.isSelected(),"Option 2 is UNSELECTED");
        WebElement option3 = driver.findElement(By.xpath("//input[@name='checkBoxOption3']"));
        Assert.assertFalse(option3.isSelected(),"Option3 is SELECTED");

        Thread.sleep(2000);
        driver.close();

    }
}
