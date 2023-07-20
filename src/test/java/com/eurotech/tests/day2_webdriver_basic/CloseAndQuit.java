package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
//        20.07.2023 --> Mac users had issue with chrome binary, so had to set its location explicitly
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver(chromeOptions);


        driver.get("http://wwww.amazon.com");

        Thread.sleep(2000);

        driver.close();   // close current tab(window)


     //   driver = new ChromeDriver();
        driver.get("http://www.google.com");

        Thread.sleep(2000);

        driver.quit();   //close all browser
    }
}
