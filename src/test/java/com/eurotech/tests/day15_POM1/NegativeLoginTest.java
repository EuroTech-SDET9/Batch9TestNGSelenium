package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {


    @Test
    public void wrongPassword() {


        driver.get(ConfigurationReader.get("url"));
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        wait.until(ExpectedConditions.elementToBeClickable(understandBtn));
        understandBtn.click();
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys("Password");
        loginBtn.click();

        WebElement warningMessage = driver.findElement(By.xpath("//*[text()='Invalid Credentials!']"));
        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!");

    }

    @Test
    public void wrongPasswordWithPOM() {

        LoginPage loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.understandBtn));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("Password");
        loginPage.loginBtn.click();


        //long way
        String expectedMessage="Invalid Credentials!";
        String actualMessage=loginPage.warningMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);

        //short way
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!");



    }
}
