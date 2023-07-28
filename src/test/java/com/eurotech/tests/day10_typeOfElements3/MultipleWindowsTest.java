package com.eurotech.tests.day10_typeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void twoWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");

        // get title
        // Click "Click Here" link
        // get title of the new window

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        driver.findElement(By.linkText("Click Here")).click();
        
        String initialWindowId = driver.getWindowHandle();
        System.out.println("initialWindowId = " + initialWindowId);
        

        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            if(!handle.equals(initialWindowId)){
                driver.switchTo().window(handle);
            }
        }

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

    }

    @Test
    public void multipleWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindowId = driver.getWindowHandle();

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        clickHere.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            driver.switchTo().window(handle);
           if(driver.getTitle().equals("New Window")){
               System.out.println("title: " + driver.getTitle());
               break;
           }
        }

        // go back to initial window.
        driver.switchTo().window(parentWindowId);
        System.out.println("title: " + driver.getTitle());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
