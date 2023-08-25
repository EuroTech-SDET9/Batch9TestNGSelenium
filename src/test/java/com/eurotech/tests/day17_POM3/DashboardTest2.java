package com.eurotech.tests.day17_POM3;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();

    PostsPage postsPage = new PostsPage();

    @Test
    public void verifyList() {

        /*
            go to "http://eurotech.study/login"
            Login with teacher credentials
            Verify login is successful
            Verify following menu
                - Edit Profile
                - Add Experience
                - Add Education
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText, expectedText, "Login verification failed");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");

        List<String> actualList = new ArrayList<>();

        // 1st way
//        for(WebElement listItem : dashboardPage.dashboardList){
//            actualList.add(listItem.getText());
//        }
//
//        System.out.println(expectedList);
//        System.out.println(actualList);
//
//        Assert.assertEquals(actualList, expectedList, "Verifying dashboard list items");

        // 2nd way
//        List<WebElement> dashboardList = dashboardPage.dashboardList;
//        for(WebElement listItem : dashboardList){
//            actualList.add(listItem.getText());
//        }
//        Assert.assertEquals(actualList, expectedList, "Verifying dashboard list items");

        //3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList), expectedList);

    }

    @Test
    public void logout() throws InterruptedException {

        /*
            go to "http://eurotech.study/login"
            Login with teacher credentials
            Verify login is successful
            Navigate to My Account and My Posts and verify that submit button is visible
            Navigate to Log Out  and verify that logout successful
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText, expectedText, "Login verification failed");

        // 1st way of navigating to My Account menu
//        dashboardPage.navigateMenu("My Account");

        // 2nd way of navigating to My Account menu
        BrowserUtils.hover(dashboardPage.myAccount);

        dashboardPage.navigateSubMenu("My Posts");

        // 1st way of verifying Submit button is displayed
//        Assert.assertTrue(postsPage.submitButton.isDisplayed());

        // 2nd way of verifying Submit button is displayed
        BrowserUtils.verifyElementDisplayed(postsPage.submitButton);

        Assert.assertEquals(postsPage.submitButton.getAttribute("value"), "Submit");

        // logout
        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("Logout");

        // verify logout
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        Thread.sleep(3000);
    }


    @Test
    public void postComment() {
        /*
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginWithTeacher();
        String expectedText = "Welcome Teacher";
        String actualText = dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText, expectedText, "Login verification failed");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");

        String titleText = "Page Object Model";
        String postText = "Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements.";

//        postsPage.titleInput.sendKeys(titleText);
//        postsPage.postInput.sendKeys(postText);
//        postsPage.submitButton.click();
//        Assert.assertEquals(postsPage.postCreatedMessage.getText(), "Post Created", "Verifying whether the post is created successfully");

        postsPage.postComment(titleText, postText);

    }
}
