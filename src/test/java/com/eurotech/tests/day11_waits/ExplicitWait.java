package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void explicitWait() {

        //Navigate https://the-internet.herokuapp.com/dynamic_loading/1
        //Click start button
        //Verify that Hello World! text


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        WebElement helloWorldText = driver.findElement(By.cssSelector("#finish>h4"));
        //create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        Assert.assertEquals(helloWorldText.getText(),"Hello World!");
        System.out.println("message = " + helloWorldText.getText());



    }

    @Test
    public void explicitWaitExample2() {


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));

        enableBtn.click();

        WebElement inputArea = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.elementToBeClickable(inputArea));


        inputArea.sendKeys("Eurotech Was Here");



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
