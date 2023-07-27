package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testName() {
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.cssSelector("#userName"));

        // get values of attributes
        System.out.println("autocomplete:" + fullName.getAttribute("autocomplete"));
        System.out.println("placeholder:" + fullName.getAttribute("placeholder"));
        System.out.println("type:" + fullName.getAttribute("type"));
        System.out.println("id:" + fullName.getAttribute("id"));
        System.out.println("class:" + fullName.getAttribute("class"));

        // gett inner html
        WebElement fullNameBroad = driver.findElement(By.xpath("//div[@id='userName-wrapper']"));
        System.out.println("innerHTML:" + fullNameBroad.getAttribute("innerHTML"));
        System.out.println("outerHTML:" + fullNameBroad.getAttribute("outerHTML"));



        System.out.println("Page source - html:" + driver.getPageSource());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
