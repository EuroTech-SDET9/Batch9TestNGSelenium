package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);


        // switch into iframe by id
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea = driver.findElement(By.id("tinymce"));

        textArea.clear();
        textArea.sendKeys("Eurotech is here");
        Thread.sleep(1000);

        // switching back to parent frame
        driver.switchTo().parentFrame();
        // switch into iframe by index
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech is here for the second time");
        Thread.sleep(1000);


        // switching back to parent frame
        driver.switchTo().parentFrame();
        // switch into iframe using WebElement
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("Eurotech is here for the third time");
        Thread.sleep(1000);


    }


    @Test
    public void nestedIframes() {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middleText = driver.findElement(By.cssSelector("#content"));
        System.out.println("middleText = " + middleText.getText());

 
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("frame-top");
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftText = driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
        System.out.println("leftText.getText() = " + leftText.getText());


        // task:
        // print out "BOTTOM" text
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
