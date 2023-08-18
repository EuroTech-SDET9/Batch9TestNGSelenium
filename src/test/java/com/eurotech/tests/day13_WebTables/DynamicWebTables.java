package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dynamic1() {
        driver.get("https://demoqa.com/webtables");
        WebElement kierraCell = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[1]"));
        System.out.println("Before click: " + kierraCell.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        System.out.println("After click: " + kierraCell.getText());
    }

    @Test
    public void dynamic2() {
        driver.get("https://demoqa.com/webtables");
        WebElement kierraCell = driver.findElement(By.xpath("//*[text()='kierra@example.com']/../div[1]"));
        System.out.println("Before click: " + kierraCell.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        // This webpage needs the WebElement to be reassigned after order is changed
        // It is like initial position of the locator is cached, so we need to refresh it
        kierraCell = driver.findElement(By.xpath("//*[text()='kierra@example.com']/../div[1]"));
        System.out.println("After click: " + kierraCell.getText());
        Assert.assertEquals(kierraCell.getText(), "Kierra");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
