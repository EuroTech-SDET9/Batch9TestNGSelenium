package com.eurotech.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebDriver driver = new ChromeDriver();

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
