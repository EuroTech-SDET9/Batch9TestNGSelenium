package com.eurotech.tests.day9_typeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        Select select = new Select(colorDropdown);

        // verify there 11 colors in this dropdown
        int expectedSize = 11;
        List<WebElement> options = select.getOptions();
        int actualSize = options.size();
        Assert.assertEquals(actualSize, expectedSize, "verifying there are " + expectedSize + " in the  color dropdown");

        // print out all the options
        for(WebElement option : options){
            System.out.println(option.getText());
        }

        // verify the initial/default/firsSelected color is "Red"
        String expectedSelectedColor = "Red";
        String actualSelectedColor = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedColor, expectedSelectedColor, "Verifying first selected color is Red");

        // Select Yellow by visibleText and verify it has been selected
        select.selectByVisibleText("Yellow");
        Thread.sleep(1000);
        Assert.assertTrue("Yellow".equals(select.getFirstSelectedOption().getText()), "verifying that the selected color is Yellow");


        // Select Green by index and verify it has been selected
        select.selectByIndex(2);
        Thread.sleep(1000);
        Assert.assertTrue("Green".equals(select.getFirstSelectedOption().getText()), "verifying that the selected color is Green");

        // Select Indigo by selectByValue and verify it has been selected
        select.selectByValue("8");
        Thread.sleep(1000);
        Assert.assertTrue("Indigo".equals(select.getFirstSelectedOption().getText()), "verifying that the selected color is Indigo");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
