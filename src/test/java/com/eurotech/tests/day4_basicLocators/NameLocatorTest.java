package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameLocatorTest {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.manage().window().maximize();

        Faker faker = new Faker();
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.name("password")).sendKeys(faker.internet().password());

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
