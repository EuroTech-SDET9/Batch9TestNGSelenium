package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExamples {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void threadSleep() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));

        startBtn.click();

        Thread.sleep(5000);

        WebElement helloText = driver.findElement(By.cssSelector("#finish>h4"));

        System.out.println(helloText.getText());



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
