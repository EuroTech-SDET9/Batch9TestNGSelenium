package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void hoverTest() {

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

        //Actions --> class that contains all the user interactions
        //How to create actions object --> passing driver as a constructor

        Actions actions = new Actions(driver);

        //perform() --> perform the action , complete the action
        //move to element --> move you mouse to web element (hover over)
        actions.moveToElement(img1).perform();

        WebElement view_profile = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(view_profile.isDisplayed());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
