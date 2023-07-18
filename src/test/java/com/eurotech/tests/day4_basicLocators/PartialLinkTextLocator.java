package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartialLinkTextLocator {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        driver.findElement(By.partialLinkText("Example 2")).click();

        String expectedText = "Example 2: Element rendered after the fact";
        WebElement example2 = driver.findElement(By.tagName("h4"));
        String actualText = example2.getText();

        if(expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
