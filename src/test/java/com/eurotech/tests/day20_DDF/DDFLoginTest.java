package com.eurotech.tests.day20_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object [][] userData(){

    ExcelUtil excelUtil = new ExcelUtil("src/test/resources/EurotechTest.xlsx","Login Test");

    String [][] dataArray =excelUtil.getDataArrayWithoutFirstRow();

    return dataArray;
}

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username, String password,String title,String company,String name) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(name+" 's login test");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("User enter username and password");
        loginPage.login(username,password);


        String expectedMessage = "Welcome "+name;
        String actualMessage = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify user log in successfully");
        Assert.assertEquals(actualMessage,expectedMessage);


        //Home work
        //verify user's title and company

    }
}
