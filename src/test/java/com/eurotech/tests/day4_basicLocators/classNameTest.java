package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();

        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");

        driver.findElement(By.name("password")).sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.className("my-2"));
        System.out.println("editProfile.getText() = " + title.getText());

        driver.close();
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/");
        driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("Test123");
        //it will not work , because there is a space in class name value

        driver.close();

    }
}
