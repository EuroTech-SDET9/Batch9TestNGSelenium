package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.id("userName"));

        Faker faker = new Faker();
        userNameInput.sendKeys(faker.name().fullName());

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(faker.internet().emailAddress());

        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());


        driver.findElement(By.id("submit")).click();


        Thread.sleep(1000);
        driver.close();
    }
}
