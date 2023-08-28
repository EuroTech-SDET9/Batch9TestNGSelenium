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
        driver = WebDriverFactory.getDriver("firefox");

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

    @Test
    public void dragAndDrop() {

        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals(verifyMessage.getText(),"Dropped!");

    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        WebElement acceptBtn = driver.findElement(By.id("droppableExample-tab-accept"));
        actions.contextClick(acceptBtn); //right click
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(5000).release().perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals(verifyMessage.getText(),"Dropped!");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
