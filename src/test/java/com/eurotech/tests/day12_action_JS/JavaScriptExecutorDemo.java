package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void clickWithJS() {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement china = driver.findElement(By.linkText("China"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", china);  //force click

    }

    @Test
    public void typeWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text = "Hello Disabled Input";

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);


    }

    @Test
    public void scrollUpAndScrollDown() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        Thread.sleep(2000);
      //  jse.executeScript("window.scrollBy(0,500)");

        //scroll Down
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        //scroll Up
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement spain = driver.findElement(By.linkText("Spain"));
        jse.executeScript("arguments[0].scrollIntoView(true);",spain);
        jse.executeScript("arguments[0].click();", spain);



        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
