package com.eurotech.tests.day12_action_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void uploadFile() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys("/Users/erhanilgar/Desktop/Eurotech.rtf");



        /*
        window user

        C:\Users\Admin\Desktop\bwtywnsy.rtf
        if it doesn't work
        try
        this --> C:/Users/Admin/Desktop/bwtywnsy.rtf

         */


        WebElement upload = driver.findElement(By.id("file-submit"));

        upload.click();


    }

    @Test
    public void upload2() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        System.out.println("System.getProperty" + System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");

        String filePath ="src/test/resources/EurotechBatch9.txt";



        String fullPath = projectPath +"/"+ filePath;
        System.out.println("fullPath = " + fullPath);

        chooseFile.sendKeys(fullPath);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
