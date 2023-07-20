package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();

//        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("eurotech@gmail.com");

        driver.findElement(By.name("password")).sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);


        System.out.println("//p= " + driver.findElement(By.tagName("p")).getText());

        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println("title = " + title.getText());


        Thread.sleep(2000);
        driver.close();
    }


}
