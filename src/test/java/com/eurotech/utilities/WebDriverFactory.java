package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {




    //Task
    //write a static method it takes a string parameter (browserType)
    //it will setup browser
    //and this method return type chromedriver or firefoxdriver object (webdriver)
    //name is getDriver

    public static WebDriver getDriver(String browserType){

        WebDriver driver =null;

        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
//                initial version:
//                driver = new ChromeDriver();
//                break;
//                second version:
//                20.07.2023 --> Mac users had issue with chrome binary, so had to set its location explicitly
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }
        return driver;
    }

}
