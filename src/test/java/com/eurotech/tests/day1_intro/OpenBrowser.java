package com.eurotech.tests.day1_intro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args)  {

        // Chrome
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com/");
//        driver.close();

        // Firefox
     //   WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
        driver.close();

    }

}
