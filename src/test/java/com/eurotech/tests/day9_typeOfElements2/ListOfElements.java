package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> listItems = driver.findElements(By.xpath("//a[text()='A/B Testing']/../..//li/a"));

        int expectedSize=44;
        int actualSize = listItems.size();

        //verify the total number list items
        Assert.assertEquals(actualSize, expectedSize, "Verifying there are " + expectedSize + " items");

        // print all the items in the list
        for(WebElement item : listItems){
            System.out.println(item.getText());
        }

        // iterate over list items and click the "Checkboxes"
        String itemToClick = "Checkboxes";
        for(WebElement item : listItems){
            if(itemToClick.equals(item.getText())){
                System.out.println("Item to click " + itemToClick + " is found, will click");
                item.click();
                Thread.sleep(2000);
               break;
            }
        }

    }


    @Test
    public void test2() {
        // homework
        // navigate to "https://demoqa.com/elements"
//         Elements list - verify the size =9
//        assert every option is displayed on the page
//        print out all the options


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
