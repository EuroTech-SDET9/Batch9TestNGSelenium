package com.eurotech.tests.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidCredentialsTest extends TestBase {

    @Test
    public void wrongUsername() {
        LoginPage loginPage = new LoginPage();
        //name of the test
        extentLogger = report.createTest("TC001 Login Test - invalid username");

        // steps
        extentLogger.info("Go to url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter invalid/wrong username");
        loginPage.usernameInput.sendKeys("euro@gmail.com");

        extentLogger.info("Enter valid password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        String expectedMessage = "Invalid Credentials";
        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verifying that user cannot login");
        Assert.assertEquals(actualMessage, expectedMessage, "Verifying Invalid Credentials! warning message is received");

        extentLogger.pass("Passed");

    }

    @Test
    public void wrongPassword() {
        /*
        Task
        Navigate to http://eurotech.study/login
        enter valid username but invalid password
        validate user cannot login
         */

        LoginPage loginPage = new LoginPage();
        //name of the test
        extentLogger = report.createTest("TC001 Login Test - invalid password");

        // steps
        extentLogger.info("Go to url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter valid username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter invalid/wrong  password");
        loginPage.passwordInput.sendKeys("blabla");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        String expectedMessage = "Invalid Credentials";
        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verifying that user cannot login");
        Assert.assertEquals(actualMessage, expectedMessage, "Verifying Invalid Credentials! warning message is received");

        extentLogger.pass("Passed");
    }
}
