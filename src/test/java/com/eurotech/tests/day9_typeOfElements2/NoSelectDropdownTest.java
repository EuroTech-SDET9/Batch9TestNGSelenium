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

import java.sql.SQLOutput;
import java.util.List;

public class NoSelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test() {

        // navigate to "https://demo.aspnetawesome.com/"
        // verify there are 25 options
        // print all of them
        // verify that 4th option Banana
        // click Cherry
        // verify that Cherry is selected

        driver.get("https://demo.aspnetawesome.com/");
        WebElement dropDown = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[8]"));

//        Select select = new Select(dropDown); // org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "div"

        WebElement firstSelectedOption = driver.findElement(By.xpath("(//div[@class='o-cptn'])[8]"));
        Assert.assertEquals(firstSelectedOption.getText(), "Mango", "Verifying Mango is the selected option");

        dropDown.click();

        List<WebElement> dropDownList = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[8]/li"));

        System.out.println("Number of options: " + dropDownList.size() );

        Assert.assertEquals(dropDownList.size(), 25, "Verifying that size of list is 25");

        for(WebElement fruit : dropDownList){
            System.out.println(fruit.getText());
        }

        String expectedFruit = "Banana";
        String actualFruit = dropDownList.get(3).getText();
        Assert.assertEquals(actualFruit, expectedFruit, "Verifying 4th option is Banana");


        dropDownList.get(4).click();
        // alternatively you can loop through the dropDownList and get the text of each item and stop when you have Cherry


        Assert.assertEquals(firstSelectedOption.getText(), "Cherry", "Verifying Cherry is the selected option");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
