package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        /*
        --navigate https://rahulshettyacademy.com/AutomationPractice/
        --Verify that radio button 2 is unselected
        --Click radio button 2
        --verify that radio button 2 is selected

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement radio2 = driver.findElement(By.cssSelector("[value='radio2']"));


        //Verify that radio button 2 is unselected
        Assert.assertFalse(radio2.isSelected(),"Be careful Radio2 is SELECTED"); // Radio2 is unselected

        radio2.click();
        Assert.assertTrue(radio2.isSelected(),"Radio2 is UNSELECTED");

        //click Radio 3
        WebElement radio3 = driver.findElement(By.cssSelector("[value='radio3']"));
        radio3.click();


        //Verify that radio button 3 is selected
        Assert.assertTrue(radio3.isSelected(),"Radio3 is UNSELECTED");
        Assert.assertFalse(radio2.isSelected(),"Be careful Radio2 is SELECTED");



        Thread.sleep(2000);
        driver.close();
    }
}
