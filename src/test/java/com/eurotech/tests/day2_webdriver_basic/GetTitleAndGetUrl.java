package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetTitleAndGetUrl {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
//        20.07.2023 --> Mac users had issue with chrome binary, so had to set its location explicitly
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://www.facebook.com");

        String title=driver.getTitle();
        System.out.println("title = " + title);

        String expectedTitle=  "Facebook – log in or sign up";
        String actualTitle=driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getPageSource() = " + driver.getPageSource());


        Thread.sleep(2000);
        driver.close();
    }
}
