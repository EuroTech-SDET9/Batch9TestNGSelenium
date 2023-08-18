package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTests {

//    @Test
//    public void test1() throws InterruptedException {
//
////        1st way
////       WebDriver driver = WebDriverFactory.getDriver("chrome");
//
////       2nd way
////        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
//
////        3rd way
//        WebDriver driver = Driver.get();
//
//        driver.get(ConfigurationReader.get("url"));
//
//        Thread.sleep(1000);
//
//        Driver.closeDriver();
//
//    }


    @Test
    public void test2() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com/");

        Thread.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();

        driver.get("https://en-gb.facebook.com/");

        Thread.sleep(1000);
    }


}
