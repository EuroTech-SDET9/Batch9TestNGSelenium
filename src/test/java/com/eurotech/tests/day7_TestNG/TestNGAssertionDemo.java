package com.eurotech.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("Opening Browser");
    }

  //  @Test
    public void test1() {

        System.out.println("First Assertions");
        Assert.assertEquals("title","titlE","Check the TITLES");


        System.out.println("Second Assertions");
        Assert.assertEquals("url","ur");

    }


    @Test
    public void test2() {
        Assert.assertEquals("test","tesT","Tests ARE NOT EQUALS");
    }

    @Test
    public void test3() {
        String expectedTitle = "Euro";
        String actualTitle ="Eurotech";

     //   Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));

        Assert.assertNotEquals("Title","Title","They are NOT EQUALS");

    }

    @Test
    public void test4() {
     //   String actualEmail = email.getText();
        String email ="johndoe@gmail.com";
        Assert.assertTrue(email.contains("@"));


    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}
