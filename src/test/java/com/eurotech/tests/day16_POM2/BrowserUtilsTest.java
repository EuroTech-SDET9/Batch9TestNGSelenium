package com.eurotech.tests.day16_POM2;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class BrowserUtilsTest extends TestBase {

    @Test
    public void window() {

        driver.get("https://the-internet.herokuapp.com/windows");

        // get title
        // Click "Click Here" link
        // get title of the new window

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        driver.findElement(By.linkText("Click Here")).click();
        BrowserUtils.switchToWindow("New Window");
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void action() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

       BrowserUtils.hover(img1);

    }

    @Test
    public void list() {
        driver.get("https://the-internet.herokuapp.com/");

       List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='Broken Images']/../../li"));

        System.out.println("BrowserUtils.getElementsText(menuList) = " + BrowserUtils.getElementsText(menuList));

    }
}
