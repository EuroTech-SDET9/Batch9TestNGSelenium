package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void implicitWaitExample() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement text = driver.findElement(By.id("message"));
        System.out.println("text.getText() = " + text.getText());


    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("message.getText() = " + message.getText());

    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
