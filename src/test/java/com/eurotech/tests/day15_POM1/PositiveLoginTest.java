package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();


    @Test
    public void positiveLogin() throws InterruptedException {


        driver.get(ConfigurationReader.get("url"));

        loginPage.understandBtn.click();
        loginPage.usernameInputFindAll.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");



    }

    @Test
    public void loginWithStudent() {

        driver.get(ConfigurationReader.get("url"));
        BrowserUtils.waitForVisibility(loginPage.understandBtn,10);
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameStudent"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordStudent"));
        //loginPage.loginBtn.click();
        BrowserUtils.clickWithJS(loginPage.loginBtn);


    }

    @Test
    public void loginWithMethod() {
        driver.get(ConfigurationReader.get("url"));
        String username =ConfigurationReader.get("usernameStudent");
        String password = ConfigurationReader.get("passwordStudent");
        loginPage.login(username,password);
    }

    @Test
    public void loginWithStudent2() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithStudent();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    @Test
    public void loginWithTeacher() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }
}
