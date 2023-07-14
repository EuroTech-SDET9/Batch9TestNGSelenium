package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://wwww.amazon.com");

        Thread.sleep(2000);

        driver.close();   // close current tab(window)


     //   driver = new ChromeDriver();
        driver.get("http://www.google.com");

        Thread.sleep(2000);

        driver.quit();   //close all browser
    }
}
