package com.eurotech.tests.day19_review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /*
        --Login as a teacher
        --Verify that login is successful
        --Click on Edit Profile button
        --Verify that Github name is eurotech2023
        --Click on back button
        --Verify that user's Apple company title is Test Automation Engineer

     */

    @Test
    public void userInfo() {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();
        // 10 min
        extentLogger = report.createTest("User Info Verification");

        extentLogger.info("Navigate to http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Login as teacher");
        loginPage.loginWithTeacher();


        //                     DASHBOARD PAGE                          //

        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify that welcome message is "+expectedText);
        Assert.assertEquals(actualText,expectedText);

        //                     PROFILE PAGE                          //
        extentLogger.info("Click on Edit Profile Button");
        dashboardPage.navigateMenu("Edit Profile");

        BrowserUtils.scrollToElement(profilePage.goBack);

        String expectedGithubName = "eurotech2023";
        String actualGithubName = profilePage.githubName.getAttribute("value");
        System.out.println("actualGithubName = " + actualGithubName);

        extentLogger.info("Verify that github name is "+expectedGithubName);
        Assert.assertEquals(actualGithubName,expectedGithubName);

        extentLogger.info("Click on go back button");
        profilePage.goBack.click();

        //                     DASHBOARD PAGE                          //

        extentLogger.info("Verify that Apple's company Job Title is Test Automation Engineer");
        String expectedJobTitle ="Test Automation Engineer";
        String actualJobTitle = dashboardPage.jobTitle.getText();
        Assert.assertEquals(actualJobTitle,expectedJobTitle);

        extentLogger.info("Passed");





    }
}
