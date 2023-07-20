package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {


        /*
        navigate facebook
        wait 2 seconds
        navigate amazon
        wait two seconds
        go back previous page
        wait 2 seconds
        go forward
        wait 2 seconds
        refresh the page
        wait 2 seconds
        close the driver
         */

        WebDriverManager.chromedriver().setup();
//        20.07.2023 --> Mac users had issue with chrome binary, so had to set its location explicitly
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://www.facebook.com");

        //Waiting method
        Thread.sleep(2000);


        driver.navigate().to("http://www.amazon.com");
        Thread.sleep(2000);


        //goes back previous page
        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();


        driver.close();


    }
}
